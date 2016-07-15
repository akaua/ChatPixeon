function onSignIn(googleUser) {
                        // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());

                        // The ID token you need to pass to your backend:
    var id_token = googleUser.getAuthResponse().id_token;        
    console.log("ID Token: " + id_token);
    
    var jsonPost = {
        "name" : profile.getName(),
        "id" : profile.getId()
    };

   $.when(
        $.ajax({  
                url:'https://chatpixeonservice.herokuapp.com/login',//'http://localhost:9999/login',  
                type:'POST',
                data : JSON.stringify({"givenName" : profile.getGivenName() , "name" : profile.getName() , "id" : profile.getId()}),  // "{\"name\":\"akaua\",\"id\":\"123\"}",
                contentType : "application/json; charset:ISO-8859-1",//utf-8",   
               // headers: {
                //    'Access-Control-Allow-Origin' : 'http://localhost:9999/',
                //},
                //dataType: 'JSON',
               success: function(data) { 
                         //var jsonData = $.parseJSON(data); //if data is not json
                         //$('#name').val(jsonData.name);  
                         //$('#email').val(jsonData.email);  
                         console.log("POST REALIZADO COM SUCESSO")
                    }  
        })
    ).then(function() {
            /* Run after all AJAX */
            console.log('After POST AJAX!!');
            document.getElementById('chat').click();
            $('#btIn').hide();
            $('#btOut').show();
    });
};

function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
          console.log('User signed out.');
        });

        
            document.getElementById('logout').click();
            location.reload();

      //  $.when(
       //     $.ajax({  
        //            url:'http://localhost:9999/logaut',  
        //            type:'POST',
        //            data : JSON.stringify({"givenName" : profile.getGivenName() , "name" : profile.getName() , "id" : profile.getId()}),
        //            contentType : "application/json; charset:ISO-8859-1",//utf-8",   
                   // headers: {
                    //    'Access-Control-Allow-Origin' : 'http://localhost:9999/',
                    //},
                    //dataType: 'JSON',
        //           success: function(data) { 
        //                     var jsonData = $.parseJSON(data); //if data is not json
        //                     $('#name').val(jsonData.name);  
        //                     $('#email').val(jsonData.email);  
        //                     console.log("LOGAUT REALIZADO COM SUCESSO")
        //                }  
       //     })
       // ).then(function() {
            /* Run after all AJAX */
       //     document.getElementById('logout').click();
       //     location.reload();
        //});

        
};  