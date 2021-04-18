$( document ).ready(function() {
    
    if (window.history.replaceState) { // verificamos disponibilidad
        window.history.replaceState(null, null, window.location.href);
    }
    /* Inicialización de variables globales. */
    const body = document.querySelector('body');
    const btn = document.querySelector('.sidemenu__btn');
    const wrapper = document.querySelector('.wrapper');
    let w = window.innerWidth;
    /**
     * Funcionalidades para el componente de producción.
     */
    if (body.id === 'inventario') {
        const btn_ingreso = document.querySelector('#btn_ingreso');
        const btn_clear = document.querySelector('#btn__clear');
        const btn_ingreso_ico = document.querySelector('.fa');
        const content_ingreso = document.querySelector('#formingreso');
        const input_fecha = document.querySelector('#fecha_lote');
        //Setear inputs a vacios
        clearFormInventory();
        let today = new Date();
        let dia = today.getDate() + 1;
        let mes = today.getMonth() + 1;
        let anio = today.getFullYear();
        if ( dia < 10) {
            dia = '0' + dia;
        }
        if ( mes < 10 ) {
            mes = '0' + mes;
        }
        today = anio + '-' + mes + '-' + dia;
        input_fecha.setAttribute('max', today);

        btn_ingreso.addEventListener('click', e => {
            btn_ingreso_ico.classList.toggle('fa-plus');
            btn_ingreso_ico.classList.toggle('fa-minus');
            content_ingreso.classList.toggle('content--collapsed');
            content_ingreso.classList.toggle('content--expanded');
        });

        btn_clear.addEventListener('click', clearFormInventory);
    }

    if ( body.id === 'ventas' ) {
        const btn_venta = document.querySelector('#btn_venta');
        const btn_clear = document.querySelector('#btn__clear');
        const btn_ingreso_ico = document.querySelector('.fa');
        const content_venta = document.querySelector('#formventa');
        const content_factura = document.querySelector('.four-content-form');
        const input_fecha = document.querySelector('#fecha_venta')
        clearFormSell();
        clearFormInventory();
        let today = new Date();
        let dia = today.getDate() + 1;
        let mes = today.getMonth() + 1;
        let anio = today.getFullYear();
        if ( dia < 10) {
            dia = '0' + dia;
        }
        if ( mes < 10 ) {
            mes = '0' + mes;
        }
        today = anio + '-' + mes + '-' + dia;
        input_fecha.setAttribute('max', today);
        btn_venta.addEventListener('click', e => {
            btn_ingreso_ico.classList.toggle('fa-plus');
            btn_ingreso_ico.classList.toggle('fa-minus');
            content_venta.classList.toggle('content--collapsed');
            content_venta.classList.toggle('content--expanded');
        });

        $('#venta_factura').change(function(){
            var selectValue = $('#venta_factura').val();
            if(selectValue == '0'){
                content_factura.classList.add('factura--collapsed');
            }
            if(selectValue == '1') {
                content_factura.classList.remove('factura--collapsed');
            }
        }); 

        btn_clear.addEventListener('click', clearFormSell);

    }
    /**
     * Funcionalidades para los componentes de login y registro.
     */
    if (body.id === 'login' || body.id === 'registro' || body.id === 'inventario' || body.id === 'ventas') {
        const inputs = document.querySelectorAll('.login__input');
        inputs.forEach( input =>{
            input.addEventListener('focus', focusTransitionInput);
            input.addEventListener('blur', blurTransitionInput);
        });
    }
    
    if ( body.id === 'panel' ) {
        const btn_clientes = document.querySelector('.tab--clientes');
        const btn_sucursales = document.querySelector('.tab--sucursales');
        const btn_proveedores = document.querySelector('.tab--proveedores');
        const btn_productos = document.querySelector('.tab--productos');
        const header_cliente = document.querySelector('.header--clientes');
        const tabla_cliente = document.querySelector('.tabla--clientes');
        const header_sucursales = document.querySelector('.header--sucursales');
        const tabla_sucursales = document.querySelector('.tabla--sucursales');
        const header_proveedores = document.querySelector('.header--proveedores');
        const tabla_proveedores = document.querySelector('.tabla--proveedores');
        const header_productos = document.querySelector('.header--productos');;
        const tabla_productos = document.querySelector('.tabla--productos');

        btn_clientes.addEventListener('click', e => {
            header_cliente.classList.remove('content--collapsed');
            tabla_cliente.classList.remove('content--collapsed');
            header_sucursales.classList.add('content--collapsed');
            tabla_sucursales.classList.add('content--collapsed');
            header_proveedores.classList.add('content--collapsed');
            tabla_proveedores.classList.add('content--collapsed');
            header_productos.classList.add('content--collapsed');
            tabla_productos.classList.add('content--collapsed');
        });
        btn_sucursales.addEventListener('click', e => {
            header_sucursales.classList.remove('content--collapsed');
            tabla_sucursales.classList.remove('content--collapsed');
            header_cliente.classList.add('content--collapsed');
            tabla_cliente.classList.add('content--collapsed');
            header_proveedores.classList.add('content--collapsed');
            tabla_proveedores.classList.add('content--collapsed');
            header_productos.classList.add('content--collapsed');
            tabla_productos.classList.add('content--collapsed');
        });
        btn_proveedores.addEventListener('click', e => {
            tabla_proveedores.classList.remove('content--collapsed');
            header_proveedores.classList.remove('content--collapsed');
            header_sucursales.classList.add('content--collapsed');
            tabla_sucursales.classList.add('content--collapsed');
            header_cliente.classList.add('content--collapsed');
            tabla_cliente.classList.add('content--collapsed');
            header_productos.classList.add('content--collapsed');
            tabla_productos.classList.add('content--collapsed');
        });
        btn_productos.addEventListener('click', e => {
            header_productos.classList.remove('content--collapsed');
            tabla_productos.classList.remove('content--collapsed');
            header_sucursales.classList.add('content--collapsed');
            tabla_sucursales.classList.add('content--collapsed');
            header_cliente.classList.add('content--collapsed');
            tabla_cliente.classList.add('content--collapsed');
            header_proveedores.classList.add('content--collapsed');
            tabla_proveedores.classList.add('content--collapsed');
            
        });

    }

    $('#date-time').text(obtenerFecha());
    setInterval(function(){
    $('#date-time').text(obtenerFecha());
    }, 1000)
    btn.addEventListener('click', menuCollapsed);
    if (w <= 1199.98) {
        wrapper.classList.add('sidemenu--collapsed');
    } else {
        wrapper.classList.remove('sidemenu--collapsed');
    }
    $( window ).resize(function() {
        var w = window.innerWidth;
        if (w <= 1199.98) {
            wrapper.classList.add('sidemenu--collapsed');
        } else {
            wrapper.classList.remove('sidemenu--collapsed');
        } 
    });
    
});

function obtenerFecha() {
    var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "/"
    + (currentdate.getMonth()+1)  + "/" 
    + currentdate.getFullYear() + " "
    + currentdate.getHours() + ":"  
    + currentdate.getMinutes() + ":" 
    + currentdate.getSeconds()
    return datetime;
}

function focusTransitionInput() {
    let parent = this.parentNode.parentNode;
    parent.classList.add('focus');
}

function blurTransitionInput() {
    let parent = this.parentNode.parentNode;
    if (this.value == "") {
        parent.classList.remove('focus');
    }
}

function menuCollapsed() {
    const wrapper = document.querySelector('.wrapper');
    wrapper.classList.toggle('sidemenu--collapsed');
}

function clearFormInventory() {
        $('#nro_lote').val('');
        $('#kg_procesados').val('');
        $('#fecha_lote').val('');
        $('#turno').prop('selectedIndex',0);
        $('#producto').prop('selectedIndex',0);
        $('#insumo').prop('selectedIndex',0);
}

function clearFormSell () {
    $('#kg_venta').val('');
    $('#fecha_venta').val('');
    $('#monto_venta').val('');
    $('#folio_factura').val('');
    $('#monto_factura').val('');
    $('#nro_lote').prop('selectedIndex',0);
    $('#rut_cliente').prop('selectedIndex',0);
    $('#sucursal_cliente').prop('selectedIndex',0);
        

}