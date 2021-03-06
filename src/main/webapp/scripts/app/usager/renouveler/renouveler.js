'use strict';

angular.module('sejourApp')
    .config(function ($stateProvider) {
        $stateProvider
	        .state('usager/renouveler', {
	            parent: 'usager',
	            url: '/renouveler',
	            views: {
	                'content@': {
	                    templateUrl: 'scripts/app/usager/renouveler/renouveler.html',
                        controller: 'RenouvelerUsagerController'
	                }
	            },
	            resolve: {
	                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
	                    $translatePartialLoader.addPart('renouveler');
	                    return $translate.refresh();
	                }]
	            }
	        })
            .state('usager/renouveler/etudes', {
                parent: 'usager',
                url: '/renouveler/etudes',
                data: {
                    type: 'renouvellement',
                    nature: 'sejour_etudiant'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/usager/etudier/etudier.html',
                        controller: 'EtudierUsagerController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    	$translatePartialLoader.deletePart('renouveler', true); // tips to get high priority to this part
                        $translatePartialLoader.addPart('renouveler');
                        return $translate.refresh();
                    }]
                }
            });
    });
