<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/9
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="UTF-8" %>



<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('main'));

    //发ajax 填充 用上数据
    $.get(
        "${pageContext.request.contextPath}/user/saveCounts",
        function (res) {
            console.log(res);
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '持明发州App活跃用户'
                },
                tooltip: {},
                legend: {
                    data:['活跃用户']
                },
                xAxis: {
                    data: ["7天","15天","30天","90天"]
                },
                yAxis: {},
                series: [{
                    name: '活跃用户',
                    type: 'bar',
                    data:res
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart1.setOption(option);

        },
        "json"
    );

</script>
