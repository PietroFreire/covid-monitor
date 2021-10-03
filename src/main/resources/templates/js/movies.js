let URL ="http://localhost:3000/";

window.onload = function(){
    getFilmes((status, movies) => {
    showFilmes(movies);    
    })
}

function getFilmes(callback){
    var xhr = new XMLHttpRequest();
    xhr.open('GET', URL + "movies", true);
    xhr.responseType = 'json';
    
    xhr.onload = function (){
        var status = xhr.status;
        if (status === 200){
            callback(status, xhr.response);
            console.log("OK" + status);
        } else {
            console.log("NAO ACEITO" + status);
        }
    }
    xhr.send();
}

function showFilmes(movies){
   for(var i=0; i < movies.length; i++) {
       x = Array.from(movies[i].genres)
        p = " ";
       for(var j=0; j < x.length; j++){
           genreList = x[j].name;
           p += genreList + ", ";}
        document.getElementById('cards').innerHTML +=
         `<article class="card-box">
         <img src="${movies[i].image}">
         <div class="card">
             <a href=""><h2>${movies[i].name}</h2></a>
             <div class="card-info">
                 <p><span style="color:#15a9c4">Gênero</span>: ${p}</p>
                 <p><span style="color:#15a9c4">Direção</span>: ${movies[i].director}</p>
                 <p><span style="color:#15a9c4">Elenco</span>: ${movies[i].cast}</p>
             </div>
             <div class="card-description">
                 <p>
                     ${movies[i].description}
                 </p>
             </div>
             <button class="button-trailer" type="button"><a href="login.html">Assista ao Trailer</a></button>
         </div>
         </article>  
         <div class="detail-final-card">
         <br>
         </div>`;
    }
}