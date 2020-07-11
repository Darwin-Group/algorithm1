#!/bin/bash
export roncoo_eureka=./roncoo-education-server-eureka/target/server-eureka.jar
export roncoo_config=./roncoo-education-server-config/target/server-config.jar
export roncoo_gateway=./roncoo-education-server-gateway/target/server-gateway.jar
export roncoo_system=./roncoo-education-system/roncoo-education-system-service/target/system-service.jar
export roncoo_user=./roncoo-education-user/roncoo-education-user-service/target/user-service.jar
export roncoo_sba=./roncoo-education-server-sba/target/server-sba.jar
export roncoo_course=./roncoo-education-course/roncoo-education-course-service/target/course-service.jar

export roncoo_eureka_host=localhost

export roncoo_eureka_port=9901
export roncoo_config_port=9902
export roncoo_gateway_port=9903
export roncoo_system_port=9904
export roncoo_user_port=9905
export roncoo_sba_port=9906
export roncoo_course_port=9907

opt_args="-Xmx256m -Xms256m"

logs_dir=./logs

case "$1" in

startAll) 

    echo '启动注册中心 roncoo_eureka >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_eureka  --server.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    eureka_pid=`lsof -i:$roncoo_eureka_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$eureka_pid" ]
        do
            eureka_pid=`lsof -i:$roncoo_eureka_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo " roncoo_eureka pid is $eureka_pid, port is $roncoo_eureka_port"
    echo '启动注册中心  roncoo_eureka 完成 >>>>>>>>>>'

    echo '启动配置中心 roncoo_config >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_config  --server.port=$roncoo_config_port --info.eureka.host=$roncoo_eureka_host --info.eureka.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    roncoo_config_pid=`lsof -i:$roncoo_config_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$roncoo_config_pid" ]
        do
            roncoo_config_pid=`lsof -i:$roncoo_config_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo "roncoo_config pid is $roncoo_config_pid, port is $roncoo_config_port"
    echo '启动配置中心 roncoo_config 完成 >>>>>>>>>>'

    echo '启动服务网关 roncoo_gateway >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_gateway --server.port=$roncoo_gateway_port --info.eureka.host=$roncoo_eureka_host --info.eureka.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    roncoo_gateway_pid=`lsof -i:$roncoo_gateway_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$roncoo_gateway_pid" ]
        do
            roncoo_gateway_pid=`lsof -i:$roncoo_gateway_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo "roncoo_gateway pid is $roncoo_gateway_pid, port is $roncoo_gateway_port "
    echo '启动服务网关 roncoo_gateway 完成 >>>>>>>>>>'


    echo '启动system服务 roncoo_system >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_system --server.port=$roncoo_system_port --info.eureka.host=$roncoo_eureka_host --info.eureka.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    roncoo_system_pid=`lsof -i:$roncoo_system_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$roncoo_system_pid" ]
        do
            roncoo_system_pid=`lsof -i:$roncoo_system_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo "roncoo_system pid is $roncoo_system_pid, port is $roncoo_system_port "
    echo '启动system服务 roncoo_system 完成 >>>>>>>>>>'



    echo '启动用户中心服务 roncoo_user >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_user --server.port=$roncoo_user_port --info.eureka.host=$roncoo_eureka_host --info.eureka.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    roncoo_user_pid=`lsof -i:$roncoo_user_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$roncoo_user_pid" ]
        do
            roncoo_user_pid=`lsof -i:$roncoo_user_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo "roncoo_user pid is $roncoo_user_pid, port is $roncoo_user_port "
    echo '启动用户中心服务 roncoo_user 完成 >>>>>>>>>>'

    echo '启动sba服务 roncoo_sba >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_sba --server.port=$roncoo_sba_port --info.eureka.host=$roncoo_eureka_host --info.eureka.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    roncoo_sba_pid=`lsof -i:$roncoo_sba_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$roncoo_sba_pid" ]
        do
            roncoo_sba_pid=`lsof -i:$roncoo_sba_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo "roncoo_sba pid is $roncoo_sba_pid, port is $roncoo_sba_port "
    echo '启动sba服务 roncoo_sba 完成 >>>>>>>>>>'

    echo '启动课程模块服务 roncoo_course >>>>>>>>>>>>>>'
    nohup java $opt_args -jar $roncoo_course --server.port=$roncoo_course_port --info.eureka.host=$roncoo_eureka_host --info.eureka.port=$roncoo_eureka_port > $logs_dir/server-eureka.log &
    roncoo_course_pid=`lsof -i:$roncoo_course_port | grep "LISTEN" | awk '{print $2}'`
    until [ -n "$roncoo_course_pid" ]
        do
            roncoo_course_pid=`lsof -i:$roncoo_course_port | grep "LISTEN" | awk '{print $2}'`
        done
    echo "roncoo_course pid is $roncoo_course_pid, port is $roncoo_course_port "
    echo '启动课程模块服务 roncoo_course 完成 >>>>>>>>>>'

    echo  '所有服务启动完成>>>>>>>>>>>>>>>'
    ;;

stopAll)
    P_ID=`ps -ef | grep -w $roncoo_eureka | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_eureka process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_eureka killed success"
    fi

    P_ID=`ps -ef | grep -w $roncoo_config | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_config process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_config killed success"
    fi

    P_ID=`ps -ef | grep -w $roncoo_gateway | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_gateway process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_gateway killed success"
    fi

    P_ID=`ps -ef | grep -w $roncoo_system | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_system process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_system killed success"
    fi

    P_ID=`ps -ef | grep -w $roncoo_user | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_user process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_user killed success"
    fi

    P_ID=`ps -ef | grep -w $roncoo_sba | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_sba process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_sba killed success"
    fi

    P_ID=`ps -ef | grep -w $roncoo_course | grep -v "grep" | awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
        echo "===roncoo_course process not exists or stop success"
    else
        kill -9 $P_ID
        echo "roncoo_course killed success"
    fi

    echo '所有服务关闭完成>>>>>>>>>>>'
    ;;

restart)
        $0 stop
        sleep 2
        $0 start
        echo "===restartAll success==="
        ;; 

esac	
exit 0