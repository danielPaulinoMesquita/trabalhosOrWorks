// CONTROLLER ESTADO
appCliente.controller('estadoController', function($scope, $http) {
	$scope.estado = {};
	$scope.estados = [];

	listarEstados = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/estados'
		}).then(function successCallback(response) {
			$scope.estados = response.data;
		}, function errorCallback(response) {

		});

	}

	listarEstados();

	$scope.cadastrarEstado = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/estados',
			data: $scope.estado
		}).then(function successCallback(response) {
			$scope.estados.push(response.data);
			listarEstados();
			window.alert("Salvo com sucesso!!");

		}, function errorCallback(response) {

		});

	}
	
	$scope.excluirEstado= function(estado){
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/estados/'+estado.id
			
		}).then(function successCallback(response) {
			/* SPLICE EXCLUI O CLIENTE PELA POSIÇAO DELE NO ARRAY
			 * SPLICE SERVE PARA EXCLUIR O OBJETO DO ARRAY QUE ESTÁ NA MEMÓRIA
			 */
			pos=$scope.estados.indexOf(estado);
			$scope.estados.splice(pos,1)
			window.alert("Excluído com sucesso!!");
			// 
			// .splice(excluir obeto apartir da posição x, quantidade de objetos a serem excluídos)

		}, function errorCallback(response) {

		});

	}

})
