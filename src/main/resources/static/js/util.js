

var myFirebase = {

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