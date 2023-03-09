<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Join - Admin</title>
        <link href="/css/style.css" rel="stylesheet" />
        <script src="/js/fontawesome/all.6.1.0.js" crossorigin="anonymous"></script>
        <script src="/js/jquery/jquery-3.6.3.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">회원가입</h3></div>
                                    <div class="card-body">
                                        <form action="/join/process.do" name="joinForm" id="joinForm" method="POST">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputMemberId" name="inputMemberId" type="text" placeholder="Enter your first name" />
                                                        <label for="inputMemberId">ID</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputMemberName" name="inputMemberName" type="text" placeholder="Enter your last name" />
                                                        <label for="inputMemberName">이름</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" name="inputEmail" type="email" placeholder="name@example.com" />
                                                <label for="inputEmail">Email</label>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPassword" name="inputPassword" type="password" placeholder="패스워드" />
                                                        <label for="inputPassword">패스워드</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPasswordConfirm" name="inputPasswordConfirm" type="password" placeholder="Confirm password" />
                                                        <label for="inputPasswordConfirm">패스워드 확인</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputMobileNumber" name="inputMobileNumber" type="text" placeholder="모바일 번호(-포함)" />
                                                        <label for="inputMobileNumber">모바일 번호(-포함)</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputDepartment" name="inputDepartment" type="text" placeholder="부서" />
                                                        <label for="inputDepartment">부서</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                            	
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputTeam" name="inputTeam" type="text" placeholder="팀" />
                                                        <label for="inputTeam">팀</label>
                                                    </div>
                                                </div>
                                                 <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPosition" name="inputPosition" type="text" placeholder="팀" />
                                                        <label for="inputPosition">직급</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-12">
                                                    <div class="form-floating mb-3 mb-md-0">
														<p id="errorMessage" style="color:red; font-weight:900"></p>                                                    
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button type="button" onclick="memberValidation()" class="btn btn-primary btn-block" >회원가입</button></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="login.do">로그인 화면으로</a></div>
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
	        function memberValidation(){
	        	$.ajax({
	        	  url: "/api/join/member/validation.do",
	        	  type: "POST",
	        	  data: $("#joinForm").serialize(),
	        	  dataType: "JSON",
	        	  success: function( res ) {
	        	    console.log(JSON.stringify(res));
	        	    if(res.result == "false"){
	        	    	alert(res.message);
	        	    	$("#errorMessage").html(res.message)
	        	    }else{
	        	    	$("#joinForm").submit();
	        	    }
	        	  }
	        	});
	        }
        </script>
        <script src="/script/common/join.js"></script>
    </body>
</html>
