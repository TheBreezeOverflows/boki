(function(){
    function loadVaptcha() {
        var script = document.getElementById('vaptcha_v_js');
        if (script && window.vaptcha && script.loaded) {
        } else {
            script = document.createElement('script');
            protocol = 'https'; //options.https ? 'https' : 'http';
            script.src = protocol + '://v.vaptcha.com/v3.js';
            script.id = 'vaptcha_v_js';
            script.async = true
            script.onload = script.onreadystatechange = function () {
                if (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete') {
                    script.loaded = true;
                    script.onload = script.onreadystatechange = null;
                }
            };
            document.getElementsByTagName("head")[0].appendChild(script);
        }
    }
    loadVaptcha()
}())