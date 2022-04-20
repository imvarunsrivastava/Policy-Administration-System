<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Login Page</title>
                <link rel="stylesheet" href="/css/nav.css">
                <link rel="stylesheet" href="/css/loginCSS.css">
                <nav class="navbar">

                    <h1><a class="navbar" style="color: rgb(236, 238, 226) ;margin-left: 30px; margin-top: -1px;font-family: 'Times New Roman', Times, serif;">Easy Policy</a></h1>
              
                <span><img src="/images/Easy.png" class ="img" alt="image" style="margin-left:-705px ;margin-top: 3px;" height="42px" width="42px" ></span>
              
                    <ul class="nav-links" >
              
                      <div class="menu" >
              
                      
              
                      </div>
              
                    </ul>
              
                  </nav>
              </head>
            

            <body>

                <div class="container">
   
                    <div class="screen">
                        
                        <div class="screen__content">
                            <div class="logo_img">
                        
                                <h1 style="color: rebeccapurple; font-weight: 200; margin-left: 60px; margin-top: 150px;"><b>Login</b></h1>
                            </div>
                            <form:form class="login" modelAttribute="loginform" method="POST">
                                <div class="login__field">
                                    <i class="login__icon fas fa-user"></i>
                                    <form:input class="login__input" type="text" path="userName"
                                                        placeholder="User name" />
                                </div>
                                <div class="login__field">
                                    <i class="login__icon fas fa-lock"></i>
                                    <form:input class="login__input" type="password" path="password"
                                                        placeholder="Password" />
                                </div>
                                <button class="button login__submit">
                                    <span class="button__text">Login</span>
                                    <i class="button__icon fas fa-chevron-right"></i>
                                </button>				
                            </form:form>
                            <div class="social-login">
                                <div class="social-icons">
                                    <a href="#" class="social-login__icon fab fa-instagram"></a>
                                    <a href="#" class="social-login__icon fab fa-facebook"></a>
                                    <a href="#" class="social-login__icon fab fa-twitter"></a>
                                </div>
                            </div>
                        </div>
                        <div class="screen__background">
                            <span class="screen__background__shape screen__background__shape4"></span>
                            <span class="screen__background__shape screen__background__shape3"></span>		
                            <span class="screen__background__shape screen__background__shape2"></span>
                            <span class="screen__background__shape screen__background__shape1"></span>
                        </div>		
                    </div>
                </div>
                

            </body>

            </html>