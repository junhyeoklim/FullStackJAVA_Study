<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="pagination-wrapper">
	<ul class="pagination justify-content-center">
		<c:if test="${requestScope.pagingInfo.currentPage > 1}">
			<li class="page-item"><a class="page-link"
				href="<c:url value='list.do'>
                                        <c:param name='page' value='1'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&lt;&lt;</a>
			</li>
			<li class="page-item"><a class="page-link"
				href="<c:url value='list.do'>
                                        <c:param name='page' value='${requestScope.pagingInfo.currentPage - 1}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&lt;</a>
			</li>
		</c:if>
		<c:set var="startPage"
			value="${requestScope.pagingInfo.currentPage - 4 > 0 ? requestScope.pagingInfo.currentPage - 4 : 1}" />
		<c:set var="endPage"
			value="${startPage + 9 <= requestScope.pagingInfo.noOfPages ? startPage + 9 : requestScope.pagingInfo.noOfPages}" />
		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<li
				class="page-item ${requestScope.pagingInfo.currentPage == i ? 'active' : ''}">
				<a class="page-link"
				href="<c:url value='list.do'>
                                        <c:param name='page' value='${i}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">${i}</a>
			</li>
		</c:forEach>
		<c:if
			test="${requestScope.pagingInfo.currentPage < requestScope.pagingInfo.noOfPages}">
			<li class="page-item"><a class="page-link"
				href="<c:url value='list.do'>
                                        <c:param name='page' value='${requestScope.pagingInfo.currentPage + 1}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&gt;</a>
			</li>
			<li class="page-item"><a class="page-link"
				href="<c:url value='list.do'>
                                        <c:param name='page' value='${requestScope.pagingInfo.noOfPages}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&gt;&gt;</a>
			</li>
		</c:if>
	</ul>
</nav>