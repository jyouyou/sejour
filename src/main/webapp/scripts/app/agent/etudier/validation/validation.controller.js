'use strict';

angular.module('sejourApp')
    .controller('ValidationController', function ($scope, $state, Demande, Country, currentDemande) {
    	$scope.studentName = "";
    	$scope.identity = {
			images: [], 
			currentImg: {},
			currentImgIndex: 0
        };
    	$scope.project = {
			images: [], 
			currentImg: {},
			currentImgIndex: 0
    	};

    	$scope.getFormattedDate = function(date){
    		return moment(date).format("DD/MM/YYYY");
    	}
    	
        Country.get().then(function(result) {
        	$scope.countries = result;
        });
    	
        $scope.demande = currentDemande;
    	$scope.demande.project.comingDateTxt = $scope.getFormattedDate(currentDemande.project.comingDate);
    	$scope.demande.project.trainingStartTxt = $scope.getFormattedDate(currentDemande.project.trainingStart);
    	$scope.demande.identity.birthDateTxt = $scope.getFormattedDate(currentDemande.identity.birthDate);
    	$scope.studentName = currentDemande.identity.firstName + " " + currentDemande.identity.lastName;
    	$scope.project.images.push({src: "assets/fileUpload/inscriptionCertificate_kim.soon.jeen@gmail.com.png", title: "project.form.inscriptionCertificate"});
    	$scope.project.images.push({src: "assets/fileUpload/resourceProof_kim.soon.jeen@gmail.com.png", title: "project.form.resourceProof"});
    	$scope.project.currentImg = $scope.project.images[$scope.project.currentImgIndex];
    	$scope.identity.images.push({src: "assets/fileUpload/passport_kim.soon.jeen@gmail.com.jpg", title: "identity.form.passport"});
    	$scope.identity.images.push({src: "assets/fileUpload/birthAct_kim.soon.jeen@gmail.com.png", title: "identity.form.birthAct"});
    	$scope.identity.currentImg = $scope.identity.images[$scope.identity.currentImgIndex];
    	
    	$scope.nextImg = function (element) {
            element.currentImgIndex++;
            if (element.currentImgIndex >= element.images.length) {
                element.currentImgIndex = 0;
            }
            element.currentImg = element.images[element.currentImgIndex];
        },
        $scope.previousImg = function (element) {
            element.currentImgIndex--;
            if (element.currentImgIndex < 0) {
                element.currentImgIndex = element.images.length - 1;
            }
            element.currentImg = element.images[element.currentImgIndex];
        }
        
        $scope.finalDecision = function (){
    		Demande.finalDecision(currentDemande).then(function(result){
            	$state.go('etudier/validation/list')
            });
        }
    });