/*JS isn't my expertise 😉.
  This is only to demonstrate how will look the profile page*/
$(document).ready(function() {
  $(".js-profile").on("click", function(){
    $(".menu-item").removeClass("is-selected");
    $(this).addClass("is-selected");
    $(".icon-back, .profile-box").removeClass("u-hide");
    $(".message-box").addClass("u-hide");
    $(".js-title").text("Elad Shechter");
  });
  
  $(".js-home").on("click", function(){
      $(".menu-item").removeClass("is-selected");
      $(".menu-item.js-home").addClass("is-selected");
      $(".icon-back, .profile-box").addClass("u-hide");
      $(".message-box").removeClass("u-hide");
      $(".js-title").text("Home");
  });
  
  $(".js-tweet").on("click", function(){
      $(".message-box").removeClass("u-hide");
      $(".message-box-content").focus();
  });
 
});


   function expandCommentSection() {
        var commentsList = this.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("feed-item")
        for(var i =0 ; i < commentsList.length; i++){
            var commentElement = commentsList[i];
            commentElement.display = "block";
        }
}


function myFunction() {
   alert("YOU CLICKED ME!");
}

   function expandCommentSection() {



    var b = a.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("feed-item")


    //Iterate over b length and set style.display = "block"

    document.getElementsByClassName("feed-item")[0].style.display="block"



   var x = document.getElementsByClassName("feed-list");



   var element =  x[7].parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("feed-list")[0];



   x[7].parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("feed-list")[0].childNodes[3].style.display = "block";

      for (var i = 0; i < this.childNodes.length; i++) {
    if (this.childNodes[i].className == "feed-item") {
    var element = this.childNodes[i];
    console.log(element);
    alert(element);
      if (element.style.display === "none") {
    element.style.display = "block";
  } else {
    element.style.display = "none";
  }


    }
}
}



x[7].parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("feed-list")[0]




function postTweetAndPersist(){
    alert("KKKK");

    const params = {
            content: document.querySelector('#tweetBox').innerText,
            type: "Text"
        }

        var tweetData = params.content;
        var httpRequest = new XMLHttpRequest();
        httpRequest.open('POST', 'http://localhost:8080/post/tweet');
        httpRequest.setRequestHeader('Content-type', 'application/json');
        httpRequest.onreadystatechange = function () {
            if (this.status == 200 && this.readyState === 4 &) {
               document.querySelector('#tweetBox').innerText = "";
                var modifiedTweet = modify(tweetData, accountOfPostCreatorName, accountOfPostCreatorDP);
                document.querySelector('#twitterFeed').insertAdjacentHTML('afterbegin', modifiedTweet);

              console.log("The tweet has been posted succesfully !!");
            }
        };

        httpRequest.send(JSON.stringify(params));
    }





function postTweetAndPersist(){


    const params = {
            content: document.querySelector('#tweetBox').innerText,
            type: "Text"
        }

        var tweetData = params.content;
        var httpRequest = new XMLHttpRequest();
        httpRequest.open('POST', 'http://localhost:8080/post/tweet');
        httpRequest.setRequestHeader('Content-type', 'application/json');
        httpRequest.onreadystatechange = function () {
            if (this.status == 200) {
               document.querySelector('#tweetBox').innerText = "";
                var modifiedTweet = modify(tweetData, accountOfPostCreatorName, accountOfPostCreatorDP);
                document.querySelector('#twitterFeed').insertAdjacentHTML('afterbegin', modifiedTweet);

              console.log("The tweet has been posted succesfully !!");
            }
        };
        httpRequest.send(JSON.stringify(params));
    }