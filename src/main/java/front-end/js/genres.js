let URL = 'http://localhost:3000/';

window.onload = function(){
    getGeneros((status, genre) => {
        printGeneros(genre);
    })
}

function getGeneros(callback){
    var xhr = new XMLHttpRequest();
    xhr.open('GET', URL + "genre", true);
    xhr.responseType = 'json';

    xhr.onload = function(){
        var status = xhr.status;
        if (status === 200){
            callback(status, xhr.response);
            console.log("Show de Bola" + status);
        } else {
            console.log('Erro' + status);
        }
    }
    xhr.send();
}

function printGeneros(genre) {
    for(var i=0; i < genre.length; i++) {
        document.getElementById('cards').innerHTML += `
        <article class="card-box">
            <img src="${genre[i].image}">
            <div class="card-title">${genre[i].name}</div>
        </article>  
    `;
    }
}