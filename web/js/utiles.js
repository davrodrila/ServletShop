function confirmar(formu, datosmostrar){
    if (confirm('¿Seguro que deseas borrar '+datosmostrar+' ?')){
       document.getElementById(formu).submit()
    }
}