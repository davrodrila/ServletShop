<%--
    Document   : administracion
    Created on : 04-mar-2011, 21:51:26
    Author     : NOCTURO
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="persistencia.*,objetos.*,utiles.util,java.util.ArrayList,java.util.List,java.util.Iterator,presentacion.*"%>
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
              <h2>&nbsp;</h2><h2>&nbsp;</h2>
          </form>
      <%
        }
                        %>
     <h2>&nbsp;</h2>
            </div>
    <div class="main_right">
      <div class="clr"></div>
            <h2 style="padding:30px 0 5px 5px;">Modificaci&oacute;n de datos del usuario</h2><br />
        <%
                    if (util.isNumeric(request.getParameter("id"))) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Usuario u = Persistencia.obtenerUsuario(id);
                        
                        if (u != null) {
        %>
        <form method='post' action='accionModificarUsuario'>
            <table>
                <tr><td> IDUsuario: </td><td><%=u.getIDUsuario()%><input type='hidden' name='id' value='<%=u.getIDUsuario()%>'></td></tr>
                <tr><td> Login: </td><td><input type='text' name='login' value='<%=u.getLogin()%>' /> </td></tr><input type='hidden' name='loginold' value='<%=u.getLogin()%>'/>
                <tr><td> Nombre: </td><td><input type='text' name='nombre' value='<%=u.getNombre()%>'></td></tr>
                <tr><td> Apellidos: </td><td><input type='text' name='ape' value='<%=u.getApellidos()%>'></td></tr>
                <tr><td> DNI: </td><td><input type='text' name='DNI' value='<%=u.getDNI()%>'></td></tr>
                <tr><td> Email: </td><td><input type='text' name='mail' value='<%=u.getEmail()%>'></td></tr>
                <tr><td> Contrase&ntilde;a: antigua </td><td><input type='password' name='passold'></td></tr>
                <tr><td> Contrase&ntilde;a: </td><td><input type='password' name='pass'></td></tr>
                <tr><td> Repite la contraseña: </td><td><input type='password' name='pass2'></td></tr>
                <%
                if (ds.getUsuario().getRol().equalsIgnoreCase("administrador"))
                {
                    String usu="";
                    String admi="";
                    if (u.getRol().equalsIgnoreCase("usuario"))
                    {
                        usu="selected";
                    } else if (u.getRol().equalsIgnoreCase("administrador"))
                        {
                        admi="selected";
                        }
                %>
                <tr><td> Rol: </td><td>
                        <select name='Rol'>
                            <option value="usuario" <%=usu%> >Usuario</option>
                            <option value="administrador" <%=admi%>>Administrador</option>
                        </select>
                </td</tr>
                <%
                    }
                %>
                <tr><td><input type='submit' value='Modificar'></td></tr>
            </table>
        </form>
        <h3>Direcciones disponibles: </h3>
            <table>
                <tr>
                    <th>Alias</th>
                </tr>
                    <form action='altaDireccion.jsp' method='post'>
                        <input type='hidden' name='id' value='<%=id%>' />
                        <input type='submit' value='nueva' />
                    </form>
                <%
                                            List<Direccion> dl = Persistencia.listaDirecciones(id);
                                            if (dl!=null){
                                            Iterator<Direccion> i = dl.iterator();
                                            int k=0;
                                            while (i.hasNext()) {
                                                Direccion d = i.next();
                %>
                <tr><td><%=d.getAlias()%></td>
                    <td>
                        <form method='post' action='modificarDireccion.jsp'>
                            <input type='hidden' name='idu' value='<%=d.getIDUsuario()%>' />
                            <input type='hidden' name='idd' value='<%=d.getIDDireccion()%>'/>
                            <input type='submit' value='Modificar' />
                        </form>
                    </td>
                    <td>
                        <form method='post' id="BorrarDireccion<%=k%>"action='bajaDireccion' >
                            <input type='hidden' name='idu' value='<%=d.getIDUsuario()%>' />
                            <input type='hidden' name='idd' value='<%=d.getIDDireccion()%>' />
                            <input type='button' onClick='confirmar("BorrarDireccion<%=k%>","la direccion <%=d.getAlias()%>")' value='Borrar' />
                        </form>
                    </td>
                            <%
                                            k++;
                                            }
                            %>
                    <%
                                    } 
                                }
                        }
                    %>
            </table>
              <h2>&nbsp;</h2>
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
