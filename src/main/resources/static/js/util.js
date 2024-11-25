const firebaseConfig = {
    apiKey: "AIzaSyAjMo161z8lVauMCOAiynyo2xcK_SHwlxI",
    authDomain: "open-market-801f0.firebaseapp.com",
    projectId: "open-market-801f0",
    storageBucket: "open-market-801f0.firebasestorage.app",
    messagingSenderId: "486349643801",
    appId: "1:486349643801:web:bf1543d2dda44d06668a88",
    measurementId: "G-ZDKCZ2PVN5"
};


var myFirebase = {

    getBase64:async function(file){
        return new Promise(function(resolve, reject){
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function () {
                resolve(reader.result);
            };
            reader.onerror = function (error) {
                reject('Error: ', error);
            };
        });
    },
    uploadItemImage:async function(storage,base64){
        return new Promise(function(resolve,reject){
            var d = Date.now();
            var ref = storage.ref('items').child(d+".png");
            ref.putString(base64, 'data_url').then(function(snapshot){
                ref.getDownloadURL().then(function(url){
                    resolve(url);
                }).catch(function(err){
                    //에러
                });
            });
        });
    },

    uploadUserImage:async function(storage,base64,userId){
        return new Promise(function(resolve,reject){
            var d = Date.now();
            var ref = storage.ref('users').child(userId).child(d+".png");
            ref.putString(base64, 'data_url').then(function(snapshot){
                ref.getDownloadURL().then(function(url){
                    resolve(url);
                }).catch(function(err){
                    //에러
                });
            });
        });
    }
}