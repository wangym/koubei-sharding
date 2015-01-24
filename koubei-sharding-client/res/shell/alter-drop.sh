DB_SERVERS="10.9.23.105 10.9.23.106"
DB_USER=root
DB_PWD=koubei
TABLE_COUNTS=200

num=0
for((i=0;i<$TABLE_COUNTS;i++))
do
	sql=$sql"alter table store$i drop column byname, drop column address_note;"
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
