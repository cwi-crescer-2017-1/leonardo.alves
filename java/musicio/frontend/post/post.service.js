app.factory("postService", postService);

function postService ($http) {
    var url = "http://localhost:9090/api/posts";

    var addPost = (post) => $http.post(url, post);

    return {
        addPost: addPost
    }
}