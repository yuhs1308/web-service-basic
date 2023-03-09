<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Login - ADMIN</title>
        <link href="/css/style.css" rel="stylesheet" />
        <script src="/js/fontawesome/all.6.1.0.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">관리자 로그인</h3></div>
                                    <div class="card-body">
                                        <form action="/login/process.do" name="loginForm" id="loginForm" method="POST">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" name="inputId" id="inputId" value="${inputId}" type="text" placeholder="ID" />
                                                <label for="inputId">ID</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" name="inputPassword" id="inputPassword" value="${inputPassword}" type="password" placeholder="Password" />
                                                <label for="inputPassword">PASSWORD</label>
                                            </div>
                                            <div class="form-check mb-3">
                                                <input class="form-check-input" id="inputRememberPassword"  type="checkbox" value="" />
                                                <label class="form-check-label" for="inputRememberPassword">저장하기</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" type="button" href="#">패스워드 찾기</a>
                                                <button class="btn btn-primary" type="submit">로그인</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="/join.do">회원가입</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="/js/bootstrap/bootstrap.5.1.3.js" crossorigin="anonymous"></script>
        <script src="/js/common/init.js"></script>
        <script>
        var errorMessage = '${errorMessage}';
        if(errorMessage != '' && errorMessage != null){
        	alert(errorMessage)
        }
        </script>
    </body>
</html>
