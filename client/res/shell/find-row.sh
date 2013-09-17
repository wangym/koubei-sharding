DB_SERVERS="10.13.126.77 10.13.126.78"
DB_USER=root
DB_PWD=koubei
TABLE_COUNTS=200

num=0
for((i=0;i<$TABLE_COUNTS;i++))
do
	sql=$sql"select id as store$i from store$i where id='$1';"
done
for db in $DB_SERVERS
do
	echo "===================== $db ======================="
        mysql -h$db -u$DB_USER -p$DB_PWD <<EOF
                use huangye$num;
                $sql
EOF

let num=$num+1
        mysql -h$db -u$DB_USER -p$DB_PWD <<EOF
                use huangye$num;
                $sql
EOF

let num=$num+1
done

