appCliente.controller("clienteDetalheController", function($scope,
		$routeParams, $http) {

	$scope.cliente = {};

	$http.get("admin/clientes/" + $routeParams.clienteId).then(function(response) {
		// $http pra quando for fazer requisições para API
		token = localStorage.getItem("userToken");
		$http.defaults.headers.common.Authorization = 'Bearer ' + token;
		$scope.cliente = response.data;
	}, function(response) {
		console.log(response);
	});

});