DB_SERVERS="10.13.126.77 10.13.126.78"
DB_USER=root
DB_PWD=koubei
TABLE_COUNTS=200

num=0
for((i=0;i<$TABLE_COUNTS;i++))
do
	sql=$sql"TRUNCATE TABLE store$i;TRUNCATE TABLE store_plus$i;"
done
for db in $DB_SERVERS
do
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

