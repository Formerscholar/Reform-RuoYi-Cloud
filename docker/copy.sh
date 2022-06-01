#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20210908.sql ./mysql/db
cp ../sql/ry_config_20220114.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../foelep-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy foelep-gateway "
cp ../foelep-gateway/target/foelep-gateway.jar ./ruoyi/gateway/jar

echo "begin copy foelep-auth "
cp ../foelep-auth/target/foelep-auth.jar ./ruoyi/auth/jar

echo "begin copy foelep-visual "
cp ../foelep-visual/foelep-monitor/target/foelep-visual-monitor.jar  ./ruoyi/visual/monitor/jar

echo "begin copy foelep-modules-system "
cp ../foelep-modules/foelep-system/target/foelep-modules-system.jar ./ruoyi/modules/system/jar

echo "begin copy foelep-modules-file "
cp ../foelep-modules/foelep-file/target/foelep-modules-file.jar ./ruoyi/modules/file/jar

echo "begin copy foelep-modules-job "
cp ../foelep-modules/foelep-job/target/foelep-modules-job.jar ./ruoyi/modules/job/jar

echo "begin copy foelep-modules-gen "
cp ../foelep-modules/foelep-gen/target/foelep-modules-gen.jar ./ruoyi/modules/gen/jar

