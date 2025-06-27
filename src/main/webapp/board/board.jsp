<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class='wrapper'>
		<header>
			<h3 style="fontWeight: bolder">KH C CLASS</h3>
		</header>
		<nav>
			<a id='list'>게시판</a> <a id='insert'>등록</a>
		</nav>
		<div class='outer'>
			
		</div>
	</div>
	<script>
		$(function() {
			$("#list").click(function() {
				$.ajax({
					url : "<%=request.getContextPath()%>/board/list",
					method : "get",
					dataType : "html",
					/* data : {
						list : "${list}"
					}, 이렇게 작성하면 처음 페이지가 로드될 때의 list 데이터를 가져와서 
					사용하기 때문에 비동기식으로 게시글을 등록했을 때 list에 반영이 안 됨.
					데이터 누락. 따라서 boardList 서블릿에서 직접 list 가져와서 보내줘야 함 */
					success : function(data) {
						$(".outer").html(data);
					},
					error : function(xhr) {
						console.log(xhr)
					}
				});
			});
		});
		$(function() {
			$("#insert").click(function() {
				$.ajax({
					url : "<%=request.getContextPath()%>/board/insert",
					method : "get",
					dataType : "html",
					success : function(data) {
						$(".outer").html(data);
					},
					error : function(xhr) {
						console.log(xhr)
					}
				});
			});
		});
	</script>
</body>
</html>