<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/9
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 用户 统计   --%>

<div id="main1" style="width: 600px;height:400px;"></div>
<script type="text/javascript">


    $(function () {

        //ajax 查所有  来 填充数据
        $.get(
            "${pageContext.request.contextPath}/user/queryAllManCount",
            function (res) {

            $.get(
                "${pageContext.request.contextPath}/user/queryAllWomanCount",
                function (data) {

                    var myChart = echarts.init(document.getElementById('main1'));
                    option = {
                        title : {
                            text: '持明发洲App用户分布图',
                            subtext: '2018年7月9日 最新数据',
                            left: 'center'
                        },
                        tooltip : {
                            trigger: 'item'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data:['男','女']
                        },
                        visualMap: {
                            min: 0,
                            max: 2500,
                            left: 'left',
                            top: 'bottom',
                            text:['高','低'],           // 文本，默认为数值文本
                            calculable : true
                        },
                        toolbox: {
                            show: true,
                            orient : 'vertical',
                            left: 'right',
                            top: 'center',
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        series : [
                            {
                                name: '男',
                                type: 'map',
                                mapType: 'china',
                                roam: false,
                                label: {
                                    normal: {
                                        show: false
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                                data:res
                            },
                            {
                                name: '女',
                                type: 'map',
                                mapType: 'china',
                                label: {
                                    normal: {
                                        show: false
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                                data:data
                            },

                        ]
                    };
                    myChart.setOption(option);

                },
                "json"

            );


            },

            "json"
        );


    });









</script>
