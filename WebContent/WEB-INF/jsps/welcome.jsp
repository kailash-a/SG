<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<style>
* {
	-webkit-border-radius: 0 !important;
	-moz-border-radius: 0 !important;
	border-radius: 0 !important;
}
</style>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/resources/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container" style="overflow: hidden">
		<div class="page-header" style="overflow: hidden;">
			<h1 style="width: 60%;">
				SG Members - <small>Searching made easy</small>
			</h1>
			<div
				style="float: right, width:60px; , border: 1px solid grey; , overflow: hidden;">
				<div>
					<div style="font-size: large;">${greeting}</div>
					|<i class=" fa fa-users"> </i>Total ${totalCount} Users
				</div>

			</div>
		</div>
		<div style="overflow: hidden; margin: 10px;">
			<div class="col-lg-6">
				<div class="input-group">
					<input id="search" style="height: 50px;" type="text"
						class="form-control" name="search" placeholder="Search for...">
					<span class="input-group-btn">
						<button id="searchB" style="height: 50px; width: 80px;"
							class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
		</div>
		<div id="search-table" class="panel panel-default">
			<div class="panel-heading">Search Result</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example-search">
						<thead>
							<tr>
								<th>id</th>
								<th>status</th>
								<th>race</th>
								<th>weight</th>
								<th>height</th>
								<th>is Veg</th>
							</tr>
						</thead>
						<tbody id="sdata">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">All Member details</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>id</th>
								<th>status</th>
								<th>race</th>
								<th>weight</th>
								<th>height</th>
								<th>is Veg</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${members}" var="member">
								<tr
									class="<c:out value="${member.id % 2 eq 0 ? 'even gradeC': 'odd gradeX'}"/>">
									<td>${member.id}</td>
									<td>${member.status}</td>
									<td>${member.race}</td>
									<td>${member.weight}Kg's</td>
									<td>${member.height}Cm's</td>
									<td><c:choose>
											<c:when test="${member.is_veg * 1 eq 0}">
												<i class="fa fa-times"></i>
											</c:when>
											<c:when test="${member.is_veg * 1 eq 1}">
												<i class="fa fa-check"></i>
											</c:when>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>



	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/dataTables/jquery.dataTables.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(
				function() {
					$('#dataTables-example').dataTable();

					$('#searchB').click(function() {
						table=$('#dataTables-example-search').DataTable();
						table.destroy();
						$('#sdata >tr').remove();
						var criteria = $("#search").val();
						var z = s(criteria);
					});

					var s = function(criteria) {
						if(criteria===null || criteria===''){
							$('#sdata >tr').remove();
							return;
						}
						$.getJSON("search.htm", {
							search : criteria
						}).done(
								function(json) {
									//console.log("JSON Data: " + json);
									var trHTML = '';
									$.each(json, function(i, item) {
										var Tclass=(i%2==0)?'even gradeC':'odd gradeX';
										var isVeg=(item.is_veg*1 === 1) ? '<i class="fa fa-check"></i>' :'<i class="fa fa-times"></i>';
										trHTML += '<tr class='+Tclass+'><td>' + item.id
												+ '</td><td>' + item.status
												+ '</td><td>' + item.race
												+ '</td><td>' + item.weight +'Kg\'s'
												+ '</td><td>' + item.height +'Cm\'s'
												+ '</td><td>' + isVeg;
												+ '</td></tr>';
									});
									$('#sdata').append(trHTML);
									$('#dataTables-example-search').DataTable( {
										"lengthMenu": [[5, -1], [5, "All"]],
								    } );
								}).fail(function(jqxhr, textStatus, error) {
									$('#dataTables-example-search').DataTable();
						});
					}

				});
	</script>
</body>
</html>