window.addEventListener('load', function (ev) {
    let info={
        dom_id: document.getElementById('username'),
        dom_pw: document.getElementById('password')
    };
    loginResult = function(e){
        console.log(this.responseText);
    };
    document.getElementById('doLogin').addEventListener('click',function () {
      let xhr = new XMLHttpRequest();
      xhr.open('POST','/customLogin');
      xhr.addEventListener('load',loginResult);
      xhr.send('username='+info.dom_id+'&password='+info.dom_pw.value+'&'+csrf.param+'='+csrf.value);
    })
});