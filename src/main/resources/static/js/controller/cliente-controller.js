//Criando controllers
appCliente.controller("clienteController", function($scope, $http) {

	/*
	 * TREINANDO COM STRINGS $scope.nome = "jão"; $scope.sobrenome = " da
	 * silva"; $scope.nomecompleto = $scope.nome + "" + $scope.sobrenome;
	 */

	$scope.clientes = []; // DECLARANDO ARRAY NO ANGULAR
	$scope.cliente = {}; // Criando um objeto

	carregarClientes = function() {
		  token= localStorage.getItem("userToken");
		  $http.defaults.headers.common.Authorization = 'Bearer '+token;

		$http({
			method : 'GET',
			url : 'admin/clientes'
		}).then(function(response) {
			$scope.clientes = response.data;// CARREGANDO O ARRAY COM OS
			// CLIENTES DA REQUISIÇÃO
			console.log(response.data);
			console.log(response.status);
		}, function(response) {

		});
	};
	carregarClientes();

	$scope.cadastrarCliente = function() {
		if ($scope.frmCliente.$valid) {
			$http({
				method : 'POST',
				url : 'admin/clientes',
				data : $scope.cliente
			}).then(function(response) {
				$scope.clientes.push(response.data);// CARREGANDO O ARRAY COM OS
				// CLIENTES DA REQUISIÇÃO E
				// ADICIONA O CLIENTE SALVO
				carregarClientes();
				$scope.cliente = {};
				$scope.frmCliente.$setPristine(true);

			}, function(response) {
				
			});
		} else {
			window.alert("Formula´rio esta invalido");
		}
	};

	$scope.excluirCliente = function(cliente) {// CARREGANDO O ARRAY COM OS
		// CLIENTES DA REQUISIÇÃO E
		// ADICIONA O CLIENTE SALVO
		$http({
			method : 'DELETE',
			url : 'admin/clientes/' + cliente.id
		}).then(function(response) {
			// Buscar posição do Array pelo id do cliente
			// for(i=0;i<$scope.clientes.length;i++){
			// if($scope.clientes[i].id==cliente.id){
			// $scope.clientes.splice(i, 1);
			// break;
			// }
			// }

			/* SPLICE EXCLUI O CLIENTE PELA POSIÇAO DELE NO ARRAY
			 * SPLICE SERVE PARA EXCLUIR O OBJETO DO ARRAY QUE ESTÁ NA MEMÓRIA
			 */
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);

		}, function(response) {

		});
	};

	$scope.alterarCliente = function(cliente1) {
		$scope.cliente = angular.copy(cliente1);// CRIA UMA CÓPIA PARA
		// AUTUALIZAÇÃO
	};

	$scope.cancelarCliente = function() {
		$scope.cliente = {};
	}

});