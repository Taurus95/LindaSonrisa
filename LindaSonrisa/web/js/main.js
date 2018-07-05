jQuery(document).ready(function ($) {

    // Header fixed and Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
            $('#header').addClass('header-fixed');
        } else {
            $('.back-to-top').fadeOut('slow');
            $('#header').removeClass('header-fixed');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({
            scrollTop: 0
        }, 1500, 'easeInOutExpo');
        return false;
    });

    // Initiate the wowjs animation library
    new WOW().init();

    // Initiate superfish on nav menu
    $('.nav-menu').superfish({
        animation: {
            opacity: 'show'
        },
        speed: 400
    });

    // Mobile Navigation
    if ($('#nav-menu-container').length) {
        var $mobile_nav = $('#nav-menu-container').clone().prop({
            id: 'mobile-nav'
        });
        $mobile_nav.find('> ul').attr({
            'class': '',
            'id': ''
        });
        $('body').append($mobile_nav);
        $('body').prepend('<button type="button" id="mobile-nav-toggle"><i class="fa fa-bars"></i></button>');
        $('body').append('<div id="mobile-body-overly"></div>');
        $('#mobile-nav').find('.menu-has-children').prepend('<i class="fa fa-chevron-down"></i>');

        $(document).on('click', '.menu-has-children i', function (e) {
            $(this).next().toggleClass('menu-item-active');
            $(this).nextAll('ul').eq(0).slideToggle();
            $(this).toggleClass("fa-chevron-up fa-chevron-down");
        });

        $(document).on('click', '#mobile-nav-toggle', function (e) {
            $('body').toggleClass('mobile-nav-active');
            $('#mobile-nav-toggle i').toggleClass('fa-times fa-bars');
            $('#mobile-body-overly').toggle();
        });

        $(document).click(function (e) {
            var container = $("#mobile-nav, #mobile-nav-toggle");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                if ($('body').hasClass('mobile-nav-active')) {
                    $('body').removeClass('mobile-nav-active');
                    $('#mobile-nav-toggle i').toggleClass('fa-times fa-bars');
                    $('#mobile-body-overly').fadeOut();
                }
            }
        });
    } else if ($("#mobile-nav, #mobile-nav-toggle").length) {
        $("#mobile-nav, #mobile-nav-toggle").hide();
    }

    // Smoth scroll on page hash links
    $('.nav-menu a, #mobile-nav a, .scrollto').on('click', function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            if (target.length) {
                var top_space = 0;

                if ($('#header').length) {
                    top_space = $('#header').outerHeight();

                    if (!$('#header').hasClass('header-fixed')) {
                        top_space = top_space - 20;
                    }
                }

                $('html, body').animate({
                    scrollTop: target.offset().top - top_space
                }, 1500, 'easeInOutExpo');

                if ($(this).parents('.nav-menu').length) {
                    $('.nav-menu .menu-active').removeClass('menu-active');
                    $(this).closest('li').addClass('menu-active');
                }

                if ($('body').hasClass('mobile-nav-active')) {
                    $('body').removeClass('mobile-nav-active');
                    $('#mobile-nav-toggle i').toggleClass('fa-times fa-bars');
                    $('#mobile-body-overly').fadeOut();
                }
                return false;
            }
        }
    });

    // Gallery - uses the magnific popup jQuery plugin
    $('.gallery-popup').magnificPopup({
        type: 'image',
        removalDelay: 300,
        mainClass: 'mfp-fade',
        gallery: {
            enabled: true
        },
        zoom: {
            enabled: true,
            duration: 300,
            easing: 'ease-in-out',
            opener: function (openerElement) {
                return openerElement.is('img') ? openerElement : openerElement.find('img');
            }
        }
    });
    // custom code

});

function hiddeMessageError() {
    document.getElementById("error").innerHTML = "<span id='error'></span>";
}

function confirmCancelar() {
    if (confirm("¿Estas seguro de que quieres cancelar la consulta?")) {
        document.formulario.submit();
    }
}

function comprobarPass() {
    if (document.formulario.txtContrasenia.value != document.formulario.txtconfirmPass.value) {
        document.getElementById("txtconfirmPass").style.borderColor = "red";
        //document.getElementById("error").innerHTML = "<span id='error' >Las contraseñas no coinciden!</span>";
    } else {
        //document.getElementById("error").innerHTML = "<span id='error' ></span>";
        document.getElementById("txtconfirmPass").style.borderColor = "blue";
    }
}
//min date
function minDatetoday() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("dateDia").setAttribute("min", today);
}
//max date
function maxDatetoday() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("calNacimiento").setAttribute("max", today);
}
//no hay disponibilidad findesemana
function notWeekend() {
    if(document.getElementById("dateDia").value==""){
        alert("Selecciona un dia disponible en el calendario.");
        return false;
    }
    var day = new Date(document.getElementById("dateDia").value).getUTCDay();
    // Days in JS range from 0-6 where 0 is Sunday and 6 is Saturday
    if (day == 6 || day == 0) {
        document.getElementById("error").innerHTML =
                "<span  id='error' class='errormessage' style='color: red' >No\n\
     trabajamos findesemana, porfavor selecciona otro dia.</span><br>";
        return false;
    }
    document.formulario.submit();
}

function validateForm() {
    var validate = true;
    var message = " ";
    if (document.formulario.txtNombre.value == "") {
        document.formulario.txtNombre.style.borderColor = "red";
        message += "Ingresa tu nombre \n";
        validate = false;
    } else {
        document.formulario.txtNombre.style.borderColor = "green";
    }
    if (document.formulario.txtCorreo.value.trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
        document.formulario.txtCorreo.style.borderColor = "red";
        message += "Ingresa un correo valido \n";
        validate = false;
    } else {
        document.formulario.txtCorreo.style.borderColor = "green";
    }
    if (document.formulario.txtDireccion.value == "") {
        document.formulario.txtDireccion.style.borderColor = "red";
        message += "Ingresa una direccion \n";
        validate = false;
    } else {
        document.formulario.txtDireccion.style.borderColor = "green";
    }
    if (document.formulario.txtTelefono.value == "") {
        document.formulario.txtTelefono.style.borderColor = "red";
        message += "Ingresa un telefono \n";
        validate = false;
    } else {
        document.formulario.txtTelefono.style.borderColor = "green";
    }
    if (document.formulario.calNacimiento.value == "") {
        document.formulario.calNacimiento.style.borderColor = "red";
        message += "Ingresa tu fecha de nacimiento \n";
        validate = false;
    } else {
        document.formulario.calNacimiento.style.borderColor = "green";
    }
    if (document.formulario.cmbSexo.value == "0") {
        document.formulario.cmbSexo.style.borderColor = "red";
        message += "Indica tu sexo biologico \n";
        validate = false;
    } else {
        document.formulario.cmbSexo.style.borderColor = "green";
    }
    if (document.formulario.txtContrasenia.value == "") {
        document.formulario.txtContrasenia.style.borderColor = "red";
        message += "Indica una contraseña \n";
        validate = false;
    } else if (document.formulario.txtContrasenia.value != document.formulario.txtconfirmPass.value) {
        message += "Las contraseñas no coinciden! \n";
        validate = false;
    } else {
        document.formulario.txtContrasenia.style.borderColor = "green";
        document.formulario.txtconfirmPass.style.borderColor = "green";
    }

    if (validate) {
        document.formulario.submit();
        return true;
    }else{
        alert(message);
        return false;
    }
}




