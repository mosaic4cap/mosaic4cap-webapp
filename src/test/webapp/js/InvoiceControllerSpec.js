/**
 * Created by Lobedan on 27.09.2014.
 */
describe('Invoice Controller', function() {
	var scope, ctrl;

	beforeEach(function() {
		inject(function($scope) {
			$scope.invoice = [
				{
					"date": 1411855200000,
					"partials": [
						{
							"id": 1,
							"income": 111.01,
							"bills": [50],
							"ecpayment": [
								21.5,
								9.49
							],
							"store": {
								"id": 1,
								"storeKey": "Sample Store 1",
								"storeType": "HQ",
								"chef": {
									"id": 1,
									"firstName": "Konrad",
									"lastName": "Ott",
									"stores": [
										{
											"id": 2,
											"storeKey": "Sample Store 2",
											"storeType": "SIMBLING",
											"chef": 1,
											"drivers": [
												{
													"id": 3,
													"store": 2,
													"firstName": "Sample",
													"lastName": "Driver 1",
													"birthDay": "2014-09-28"
												},
												{
													"id": 8,
													"store": 2,
													"firstName": "Sample",
													"lastName": "Driver 6",
													"birthDay": "2014-09-28"
												},
												{
													"id": 4,
													"store": 2,
													"firstName": "Sample",
													"lastName": "Driver 2",
													"birthDay": "2014-09-28"
												}
											],
											"cars": [
												{
													"id": 3,
													"badge": "A-BC-003",
													"available": true,
													"store": 2
												},
												{
													"id": 4,
													"badge": "A-BC-004",
													"available": true,
													"store": 2
												},
												{
													"id": 8,
													"badge": "A-BC-008",
													"available": true,
													"store": 2
												}
											],
											"invoices": [
												{
													"id": 2,
													"income": 222.2,
													"bills": [
														12.23,
														25.23
													],
													"ecpayment": [
														4.99,
														5.99
													],
													"store": 2,
													"driver": {
														"id": 8,
														"store": 2,
														"firstName": "Sample",
														"lastName": "Driver 6",
														"birthDay": "2014-09-28"
													},
													"car": {
														"id": 2,
														"badge": "A-BC-002",
														"available": true,
														"store": 1
													},
													"date": "2014-09-28",
													"state": "OPEN",
													"modDate": 1411855200000,
													"ecamount": 10.98,
													"billAmount": 37.46
												},
												{
													"id": 8,
													"income": 888.8,
													"bills": [],
													"ecpayment": [
														5.23,
														14
													],
													"store": 2,
													"driver": {
														"id": 2,
														"store": 1,
														"firstName": "Sven",
														"lastName": "Klemmer",
														"birthDay": "2014-09-28"
													},
													"car": {
														"id": 8,
														"badge": "A-BC-008",
														"available": true,
														"store": 2
													},
													"date": "2014-09-28",
													"state": "OPEN",
													"modDate": 1411855200000,
													"ecamount": 19.23,
													"billAmount": 0
												},
												{
													"id": 5,
													"income": 555.05,
													"bills": [],
													"ecpayment": [
														21.5,
														9.49
													],
													"store": 2,
													"driver": {
														"id": 5,
														"store": {
															"id": 3,
															"storeKey": "Sample Store 3",
															"storeType": "SIMBLING",
															"chef": 1,
															"drivers": [
																{
																	"id": 9,
																	"store": 3,
																	"firstName": "Sample",
																	"lastName": "Driver 7",
																	"birthDay": "2014-09-28"
																},
																{
																	"id": 6,
																	"store": 3,
																	"firstName": "Sample",
																	"lastName": "Driver 4",
																	"birthDay": "2014-09-28"
																},
																{
																	"id": 5,
																	"store": 3,
																	"firstName": "Sample",
																	"lastName": "Driver 3",
																	"birthDay": "2014-09-28"
																}
															],
															"cars": [
																{
																	"id": 5,
																	"badge": "A-BC-005",
																	"available": true,
																	"store": 3
																},
																{
																	"id": 6,
																	"badge": "A-BC-006",
																	"available": true,
																	"store": 3
																},
																{
																	"id": 9,
																	"badge": "A-BC-009",
																	"available": true,
																	"store": 3
																}
															],
															"invoices": [
																{
																	"id": 9,
																	"income": 999.09,
																	"bills": [],
																	"ecpayment": [],
																	"store": 3,
																	"driver": {
																		"id": 1,
																		"store": 1,
																		"firstName": "Konrad",
																		"lastName": "Ã–ttl",
																		"birthDay": "2014-09-28"
																	},
																	"car": {
																		"id": 9,
																		"badge": "A-BC-009",
																		"available": true,
																		"store": 3
																	},
																	"date": "2014-09-28",
																	"state": "OPEN",
																	"modDate": 1411855200000,
																	"ecamount": 0,
																	"billAmount": 0
																},
																{
																	"id": 3,
																	"income": 333.03,
																	"bills": [],
																	"ecpayment": [
																		6,
																		14.35
																	],
																	"store": 3,
																	"driver": {
																		"id": 7,
																		"store": 1,
																		"firstName": "Sample",
																		"lastName": "Driver 5",
																		"birthDay": "2014-09-28"
																	},
																	"car": {
																		"id": 3,
																		"badge": "A-BC-003",
																		"available": true,
																		"store": 2
																	},
																	"date": "2014-09-28",
																	"state": "OPEN",
																	"modDate": 1411855200000,
																	"ecamount": 20.35,
																	"billAmount": 0
																},
																{
																	"id": 6,
																	"income": 666.6,
																	"bills": [],
																	"ecpayment": [
																		4.99,
																		5.99
																	],
																	"store": 3,
																	"driver": {
																		"id": 4,
																		"store": 2,
																		"firstName": "Sample",
																		"lastName": "Driver 2",
																		"birthDay": "2014-09-28"
																	},
																	"car": {
																		"id": 6,
																		"badge": "A-BC-006",
																		"available": true,
																		"store": 3
																	},
																	"date": "2014-09-28",
																	"state": "OPEN",
																	"modDate": 1411855200000,
																	"ecamount": 10.98,
																	"billAmount": 0
																}
															]
														},
														"firstName": "Sample",
														"lastName": "Driver 3",
														"birthDay": "2014-09-28"
													},
													"car": {
														"id": 5,
														"badge": "A-BC-005",
														"available": true,
														"store": 3
													},
													"date": "2014-09-28",
													"state": "OPEN",
													"modDate": 1411855200000,
													"ecamount": 30.990000000000002,
													"billAmount": 0
												}
											]
										},
										3,
										1
									]
								},
								"drivers": [
									{
										"id": 2,
										"store": 1,
										"firstName": "Sven",
										"lastName": "Klemmer",
										"birthDay": "2014-09-28"
									},
									{
										"id": 7,
										"store": 1,
										"firstName": "Sample",
										"lastName": "Driver 5",
										"birthDay": "2014-09-28"
									},
									{
										"id": 1,
										"store": 1,
										"firstName": "Konrad",
										"lastName": "Ã–ttl",
										"birthDay": "2014-09-28"
									}
								],
								"cars": [
									{
										"id": 1,
										"badge": "A-BC-001",
										"available": true,
										"store": 1
									},
									{
										"id": 2,
										"badge": "A-BC-002",
										"available": true,
										"store": 1
									},
									{
										"id": 7,
										"badge": "A-BC-007",
										"available": true,
										"store": 1
									}
								],
								"invoices": [
									{
										"id": 7,
										"income": 777.07,
										"bills": [37.45],
										"ecpayment": [
											6,
											14.35
										],
										"store": 1,
										"driver": {
											"id": 3,
											"store": 2,
											"firstName": "Sample",
											"lastName": "Driver 1",
											"birthDay": "2014-09-28"
										},
										"car": {
											"id": 7,
											"badge": "A-BC-007",
											"available": true,
											"store": 1
										},
										"date": "2014-09-28",
										"state": "OPEN",
										"modDate": 1411855200000,
										"ecamount": 20.35,
										"billAmount": 37.45
									},
									{
										"id": 4,
										"income": 444.4,
										"bills": [76.1],
										"ecpayment": [
											100.23,
											56.02
										],
										"store": 1,
										"driver": {
											"id": 6,
											"store": 3,
											"firstName": "Sample",
											"lastName": "Driver 4",
											"birthDay": "2014-09-28"
										},
										"car": {
											"id": 4,
											"badge": "A-BC-004",
											"available": true,
											"store": 2
										},
										"date": "2014-09-28",
										"state": "OPEN",
										"modDate": 1411855200000,
										"ecamount": 156.25,
										"billAmount": 76.1
									},
									{
										"id": 1,
										"income": 111.01,
										"bills": [50],
										"ecpayment": [
											21.5,
											9.49
										],
										"store": 1,
										"driver": {
											"id": 9,
											"store": 3,
											"firstName": "Sample",
											"lastName": "Driver 7",
											"birthDay": "2014-09-28"
										},
										"car": {
											"id": 1,
											"badge": "A-BC-001",
											"available": true,
											"store": 1
										},
										"date": "2014-09-28",
										"state": "OPEN",
										"modDate": 1411855200000,
										"ecamount": 30.990000000000002,
										"billAmount": 50
									}
								]
							},
							"driver": {
								"id": 9,
								"store": 3,
								"firstName": "Sample",
								"lastName": "Driver 7",
								"birthDay": "2014-09-28"
							},
							"car": {
								"id": 1,
								"badge": "A-BC-001",
								"available": true,
								"store": 1
							},
							"date": "2014-09-28",
							"state": "OPEN",
							"modDate": 1411855200000,
							"ecamount": 30.990000000000002,
							"billAmount": 50
						},
						{
							"id": 4,
							"income": 444.4,
							"bills": [76.1],
							"ecpayment": [
								100.23,
								56.02
							],
							"store": 1,
							"driver": {
								"id": 6,
								"store": 3,
								"firstName": "Sample",
								"lastName": "Driver 4",
								"birthDay": "2014-09-28"
							},
							"car": {
								"id": 4,
								"badge": "A-BC-004",
								"available": true,
								"store": 2
							},
							"date": "2014-09-28",
							"state": "OPEN",
							"modDate": 1411855200000,
							"ecamount": 156.25,
							"billAmount": 76.1
						},
						{
							"id": 7,
							"income": 777.07,
							"bills": [37.45],
							"ecpayment": [
								6,
								14.35
							],
							"store": 1,
							"driver": {
								"id": 3,
								"store": 2,
								"firstName": "Sample",
								"lastName": "Driver 1",
								"birthDay": "2014-09-28"
							},
							"car": {
								"id": 7,
								"badge": "A-BC-007",
								"available": true,
								"store": 1
							},
							"date": "2014-09-28",
							"state": "OPEN",
							"modDate": 1411855200000,
							"ecamount": 20.35,
							"billAmount": 37.45
						}
					],
					"store": 1,
					"state": "OPEN",
					"billAmount": 163.55,
					"ecCount": 6,
					"partialsCount": 3,
					"billCount": 3,
					"ecAmount": 207.59,
					"amount": 1332.48
				}
			];
		})
	});

	beforeEach(inject(function($controller, $rootScope) {
		scope = $rootScope.$new();
		ctrl = $controller("invoiceController", { $scope: scope });
	}));

	it('init scope invoices', function() {
		spyOn(scope, 'invoices');
		expect(scope.invoices).toHaveBeenCalled();
	});

	it('can increase for next',function() {
		scope.next();
		expect(scope.setted_par_invoice).toBe(1);

		scope.next();
		scope.next();
		expect(scope.setted_par_invoice).toBe(3);
		expect(scope.setted_par_invoice).toBe(scope.invoices[0].partialsCount);
	});
});

