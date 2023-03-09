<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>운영자 관리사이트</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/css/style.css" rel="stylesheet" />
        <script src="/js/fontawesome/all.6.1.0.js" crossorigin="anonymous"></script>
        <script src="/js/jquery/jquery-3.6.3.min.js" crossorigin="anonymous"></script>
	</head>
	<body class="sb-nav-fixed">
 		<jsp:include page="/layout/top.do"/>
        <div id="layoutSidenav">
			<jsp:include page="/layout/nav.do"/>
			
            <div id="layoutSidenav_content">
                <main>
                	<div class="container-fluid px-4">
                        <h1 class="mt-4">메뉴설정</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">메뉴목록</li>
                        </ol>
	                   	<div class="card mb-4">
		                    <div class="card-header text-end">
		                    	 메뉴리스트
		                    	<!-- 
		                        <button class="btn btn-secondary" type="button" data-bs-toggle="modal" data-bs-target="#menuRegistModal">메뉴생성</button>
		                         -->
		                    </div>
		                    <div class="card-body">
		                        <table id="datatablesSimple" class="table">
		                            <thead>
		                                <tr>
		                                    <th>IDX</th>
		                                    <th>TREE</th>
		                                    <th>URL</th>
		                                    <th>TITLE</th>
		                                    <th>하위생성</th>
		                                </tr>
		                            </thead>
		                            <tfoot>
		                                <tr>
		                                    <th>IDX</th>
		                                    <th>TREE</th>
		                                    <th>URL</th>
		                                    <th>TITLE</th>
		                                    <th>하위생성</th>
		                                </tr>
		                            </tfoot>
		                            <tbody>
		                            	<c:forEach var="menu" items="${menuList}">
	                            		<tr>
		                                    <td>${menu.AM_IDX}</td>
		                                    <td>${menu.SORT}</td>
		                                    <td>${menu.AM_URL}</td>
		                                     <td>
		                                    	<c:choose>
		                                    		<c:when test="${menu.AM_DEPTH == '0'}">
		                                    			<b>${menu.AM_TITLE}</b>
		                                    		</c:when>
		                                    		<c:when test="${menu.AM_DEPTH == '1'}">
		                                    			&nbsp;&nbsp;&nbsp;<b style="color:red">${menu.AM_TITLE}</b>
		                                    		</c:when>
		                                    		<c:when test="${menu.AM_DEPTH == '2'}">
		                                    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style="color:orange">${menu.AM_TITLE}</b>
		                                    		</c:when>
		                                    		<c:when test="${menu.AM_DEPTH == '3'}">
		                                    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${menu.AM_TITLE}
		                                    		</c:when>
		                                    		<c:otherwise>
		                                    			-
		                                    		</c:otherwise>
		                                    	</c:choose>
		                                    </td>
		                                    <td>
		                                    	<c:choose>
		                                    		<c:when test="${menu.AM_DEPTH == '0' or menu.AM_DEPTH == '1' or menu.AM_DEPTH == '2'}">
		                                    			<button class="btn btn-secondary btn-sm" type="button" data-bs-toggle="modal" data-bs-target="#menuRegistModal" data-bs-parentidx="${menu.AM_IDX}" data-bs-depth="${menu.AM_DEPTH+1}">하위메뉴생성</button>
		                                    		</c:when>
		                                    		<c:otherwise>
		                                    			-
		                                    		</c:otherwise>
		                                    	</c:choose>
		                                    </td>
		                                </tr>
		                            	</c:forEach>
		                            	
		                            </tbody>
		                        </table>
		                    </div>
	                	</div>
	                </div>
                </main>
            <jsp:include page="/layout/footer.do"/>
            </div>
		</div>
		
		<!-- Regist modal (START) -->
		<div class="modal fade" id="menuRegistModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg modal-fullscreen-lg-down">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">메뉴생성</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="menuForm">
		        	<div class="row mb-3">
                        <div class="col-md-4">
                            <div class="form-floating mb-3 mb-md-0">
                                <input class="form-control" id="inputParentIdx" name="inputParentIdx" type="text" placeholder="PARENT IDX" readonly />
                                <label for="inputParentIdx">부모IDX</label>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-floating mb-3 mb-md-0">
                                <input class="form-control" id="inputDepth" name="inputDepth" type="text" placeholder="DEPTH" readonly />
                                <label for="inputDepth">DEPTH</label>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-floating mb-3 mb-md-0">
                                <input class="form-control" id="inputSort" name="inputSort" type="text" placeholder="순서" />
                                <label for="inputSort">순서</label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-12">
                            <div class="form-floating mb-3 mb-md-0">
                                <input class="form-control" id="inputUrl" name="inputUrl" type="text" placeholder="URL" />
                                <label for="inputUrl">URL</label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-12">
                            <div class="form-floating mb-3 mb-md-0">
                                <input class="form-control" id="inputTitle" name="inputTitle" type="text" placeholder="TITLE" />
                                <label for="inputTitle">TITLE</label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-12">
                            <div class="form-floating mb-3 mb-md-0">
                                <input class="form-control" id="inputDesc" name="inputDesc" type="text" placeholder="DESC" />
                                <label for="inputDesc">DESC</label>
                            </div>
                        </div>
                    </div>
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <button type="button" class="btn btn-primary" onclick="createMenu()">생성하기</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- Regist modal (END) -->
		
		<script src="/js/bootstrap/bootstrap.5.1.3.js" crossorigin="anonymous"></script>
        <script src="/js/common/init.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="/script/menu_list.js"></script>
	</body>
</html>