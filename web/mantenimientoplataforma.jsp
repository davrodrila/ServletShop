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
        <script type="text/javascript" src="/js/utiles.js"></script>
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
          </form>
      <%
        }
                        %>

             <h2>&nbsp;</h2>
            </div>
    <div class="main_right">
      <div class="clr"></div>
              <h2>Mantenimiento de Plataformas</h2>
        <%
            if (ds!=null)
            {
            if (ds.getUsuario().getRol().equalsIgnoreCase("administrador"))
            {
                %>
        <table>
            <h1>Listado de Plataformas</h1>
            <tr>
                <th>ID</th>
                <th>Descripcion</th>
                <th>Miniatura</th>
                <%
                Plataforma p;
                List<Plataforma> pl = Persistencia.listaPlataformas();
                if (pl!=null){
                    Iterator<Plataforma> i = pl.iterator();
                    int j=0;
                while (i.hasNext())
                {
                    p = i.next();
                %>
                <tr>
                <td><%=p.getIDPlataforma()%></td>
                <td><%=p.getDescripcion()%></td>
                <td><%=p.getImagen()%></td>
                <td>
                    <form method='post' action='modificarPlataforma.jsp'>
                        <input type='hidden' name='id' value='<%=p.getIDPlataforma() %>' />
                        <input type='submit' value='Modificar' />
                        </form>
                </td>
                <td>
                    <form method='post' action='bajaPlataforma' id='<%="BorrarPlat"+j%>'>
                        <input type='hidden' name="id" value='<%=p.getIDPlataforma()%>' />
                        <input type='button' onClick='confirmar("BorrarPlat<%=j%>","la plataforma <%=p.getDescripcion()%>")' value='Borrar' />
                    </form>
                </td>
                </tr>
            <%
                j++;
                }}
            %>
            <h3><a href="altaplataforma.jsp">A&ntilde;adir plataforma</a></h3>
            </table>
                                <% } else {
            %>
            <h3>Acceso restringido</h3>
            <a href="javascript:history.go(-1)">Volver</a>
            <%
            }
            } else {
                %>
                <h3>Acceso restringido</h3>
                <a href="javascript:history.go(-1)">Volver</a>
                <%
            }
            %>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
              <h2>&nbsp;</h2>
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