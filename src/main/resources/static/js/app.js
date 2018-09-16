// Criação do modulo da aplicação
var appCliente = angular.module('appCliente', [ 'ngRoute' ]);

// Criação de controllers e cpnfigs(routers)

appCliente.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/clientes', {
		templateUrl : 'paginas/cliente.html',
		controller : 'clienteController'
	}).when('/clientes/:clienteId', {
		templateUrl : 'paginas/cliente-detalhe.html',
		controller : 'clienteDetalheController'
	}).when('/estados', {
		templateUrl : 'paginas/estado.html',
		controller : 'estadoController'
	}).when('/cidades', {
		templateUrl : 'paginas/cidade.html',
		controller : 'cidadeController'
	}).when('/login', {
		templateUrl : 'paginas/login.html',
		controller : 'loginController'
	}).otherwise({
		rediretTo : '/'
	});

	$locationProvider.html5Mode(true);
});
appCliente.config(function($httpProvider){
	$httpProvider.interceptors.push("tokenInterceptor");
});

