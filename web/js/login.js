//显示密码的小眼睛
var password = document.getElementById('password');
var anniu = document.getElementById('conceal');
anniu.addEventListener('click',function(){
    if(password.type==='password')
    {
        password.setAttribute('type','text');
        anniu.classList.add('yincang');
    }else{
    password.setAttribute('type','password');
        anniu.classList.remove('yincang');
    }
})
