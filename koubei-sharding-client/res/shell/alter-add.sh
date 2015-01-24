DB_USER=test
DB_PWD=123456
TABLE_COUNTS=200

for((i=0;i<$TABLE_COUNTS;i++))
do
        sql=$sql"alter table store$i add column byname varchar(100) NULL after subname, add column address_note varchar(255) NULL after address;"
done

echo "===================== $1 $2 ======================="
mysql -h$1 -u$DB_USER -p$DB_PWD <<EOF
use $2;
$sql