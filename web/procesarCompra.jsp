<%--
    Document   : plantilla
    Created on : 18-mar-2011, 1:44:14
    Author     : David
--%>
<%@page import="persistencia.*,objetos.*,utiles.util,java.util.ArrayList,java.util.List,java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GamES</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.cycle.all.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#slideshow').cycle({
                    fx:     'fade',
                    speed:  'slow',
                    timeout: 3000,
                    pager:  '#slider_nav',
                    pagerAnchorBuilder: function(idx, slide) {
                        // return sel string for existing anchor
                        return '#slider_nav li:eq(' + (idx) + ') a';
                    }
                });
            });
        </script>
    </head>
</head>
<body>
    <%
        HttpSession sesion = request.getSession();
        DatosSesion ds = (DatosSesion)sesion.getAttribute("ds");
        boolean usuarioValido=false;
        if (ds!=null)
        {
            usuarioValido=true;
        }
    %>
    <div class="main">
        <div class="main_resize">
            <div class="main_left">
                <div class="logo"><a href="index.jsp"><h1>Tienda de Videojuegos</h1></a></div>
                <div class="clr"></div>
                <div class="menu">
                    <ul>
                        <li><a href="index.jsp" class="active"><span>Inicio</span></a></li>
                        <li><a href="catalogo.jsp"><span>Catálogo</span></a></li>
                        <%
                        if (!usuarioValido)
                        {
%>
                        <li><a href="altausuario.jsp"><span>Registrate</span></a></li>
                        <%
                        } else if (usuarioValido)
                        {
                            if (ds.getUsuario().getRol().equalsIgnoreCase("administrador"))
                                {
                        %>
                        <li><a href="administracion.jsp"><span> Administración </span></a></li>
                        <%
                            }
                        }
                        %>
                    </ul>
                </div>
      <div class="clr"></div>
      <h2>&nbsp;</h2>
      <%
      if (usuarioValido)
       {
          %>
          <h2>¡Bienvenido, <%=ds.getUsuario().getNombre()%>!</h2>
                    <table align="center">
              <tr>
                  <td><a href="/cerrarSesion">Cerrar Sesión</a></td><td>&nbsp;</td>
                  <td><form action="modificarUsuario.jsp" name="cp" method="POST">
                          <input type="hidden" name="id" value="<%=ds.getUsuario().getIDUsuario()%>" />
                          <a href="#" onclick="document.forms.cp.submit()">Panel de control</a>
                      </form></td>
                                          <td><form action="cesta.jsp" name="cesta" method="POST">
                          <a href="#" onclick="document.forms.cesta.submit()">Ver Cesta</a>
                      </form></td>
              </tr>
          </table>
       <% } else {
         %>

          <form action="comprobarLogin" method="post" label="Acceso">
             <table style="border-spacing:10px;">
                  <tr><td><h2>Acceso</h2></td></tr>
                    <tr>
                     <td>Login: </td>
                    <td><input type="text" name="login" /></td>
                </tr>
                <tr>
                    <td>Contrase&ntilde;a: </td>
                    <td><input type="password" name="pass" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"> <input type="submit" value="Acceder" /></td>
                </tr>
            </table>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2><h2>&nbsp;</h2>
          </form>
      <%
        }
                        %>
    </div>
    <div class="main_right">
      <div class="clr"></div>
      <h2>&nbsp;</h2>
        <h1>Confirmaci&oacute;n de pedido</h1>
        <%
            if (ds!=null){
            Usuario u = ds.getUsuario();
            List<itemCesta> cesta = ds.getCesta();
        %>
        <form method="POST" action="/comprar">
        <table>
            <tr>
                <td><%=u.getNombre() +" " +u.getApellidos()%></td>
            </tr>
            <tr>
                <td>Elige una dirección de envio:</td>
            </tr>
            <tr>
                <%
                List<Direccion> dl = Persistencia.listaDirecciones(u.getIDUsuario());
                if (dl!=null){
                Iterator<Direccion> i = dl.iterator();
                Direccion d;
                while (i.hasNext()){
                    d=i.next();
                    %>
                    <td><input type="radio" checked name="direcciones" value="<%=d.getIDDireccion()%>" /><%=d.getAlias()%></td>
                    <%
                }
                %>
            </tr>
        </table>
        <table>
            <tr>
                <th>Juego</th>
                <th>Plataforma</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Total</th>
            </tr>
<%

        List<itemCesta> icl = ds.getCesta();
        Iterator<itemCesta> iic = icl.iterator();
        itemCesta ic;
        Juego j;
        Plataforma p;
        float subtotal=0;
        float total=0;
        while (iic.hasNext()) {
            ic = iic.next();
            j = Persistencia.obtenerJuego(ic.getIdjuego());
            p = Persistencia.obtenerPlataforma(ic.getIdplataforma());
            subtotal = ic.getCantidad()*ic.getPrecio();
            total +=subtotal;
%>
            <tr>
                <td><%=j.getNombre()%></td>
                <td><%=p.getDescripcion()%></td>
                <td><%=ic.getCantidad()%></td>
                <td><%=ic.getPrecio()%></td>
                <td><%=subtotal%></td>
            </tr>
<%
       }
        
%>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><strong>Total: </strong></td>
            <td><u><%=total%></u></td>
        </tr>
        </table>
        <table align="cener"><tr>
                <td><input type="submit" value="Comprar" /></td>
            </tr>
        </table>
</form>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
              <%
              }
                }
              %>
</div>
    <div class="clr"></div>
</div>
  <div class="footer">
    <div class="footer_resize">
      <p>© Copyright websitename . All Rights Reserved. Home | Contact | RSS <br />
       (Blue) <a href="http://www.bluewebtemplates.com">Website Templates</a></p>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
