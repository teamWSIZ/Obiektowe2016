var app = angular.module("myApp", []);
var url = "http://localhost:8081/";

app.controller("booksCtrl", function($scope, $http){
    $scope.info = '';

    function getBooks() {
        $http.get(url+"books").then(function(response){
            $scope.books = response.data;
        });
    }
    getBooks();

    $scope.editBookModal = function(book) {
        $scope.modalHeader = book.title;
        $scope.editBookAuthor = book.author;
        $scope.editBookTitle = book.title;
        $scope.editBookId = book.id;
    }

    $scope.editBook = function () {
        $http.put(url+"books/"+$scope.editBookId, {
            author: $scope.editBookAuthor, title: $scope.editBookTitle
            }).success(function(response){
                $scope.editBookAuthor = '';
                $scope.editBookTitle = '';
                $('#editBookModal').modal('hide');
                $scope.infoVisible = '';
                $scope.info = 'Book has been edited successfully.';
                getBooks();
            });
    }

    $scope.deleteBookModal = function(book) {
        $scope.modalHeader = book.title;
        $scope.deleteBookId = book.id;
    }

    $scope.deleteBook = function (book) {
        if($scope.deleteBookId == '') return;
        return $http({
            url: url + 'books/' + $scope.deleteBookId,
            method: 'DELETE'
        }).success(function(response) {
            $('#deleteBookModal').modal('hide');
            $scope.info = 'Book has been deleted successfully.';
            getBooks();
        });
    }

    $scope.addNewBookModal = function (book) {
        $scope.newBookAuthor = book.author;
        $scope.newBookTitle = book.title;
    }

    $scope.addNewBook = function(book) {
        $http.post(url + 'books/add?author=' + $scope.newBookAuthor + '&title=' + $scope.newBookTitle).success(function(response){
            $scope.newBookAuthor = '';
            $scope.newBookTitle = '';
            $('#addNewBookModal').modal('hide');
            console.log('Book has been inserted successfully.');
            getBooks();
        });
    }

});
