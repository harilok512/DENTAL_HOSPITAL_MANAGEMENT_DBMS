import mysql.connector
from mysql.connector import errorcode
from mysql.connector.errors import DataError, Error

table = ['Appointment', 'Bills', 'Doctor', 'patient', 'Transactions', 'Treatment']
user = 'root'
pswrd = 'mysql@123'
host = 'localhost'
database = 'dental_mngmnt_sys'

# Trying to connect to database
try:
    con = mysql.connector.connect(
        user=user,
        password=pswrd,
        host=host,
        database=database
    )
    print("Database connection successfull")
    
    # opening the file
    file= open("Tables.txt","w")
    print("File open successfull")
    cursor = con.cursor()

    # fetching the records
    for ta in table:
        cursor.execute("select * from "+ta)
        print(ta+" Information")
        file.write(ta+" Information\n")
        for rec in cursor.fetchall():
            msge=""
            for r in rec:
                msge+=str(r)+"\t"
            msge+="\n"

            # writing the records to the txt file
            file.write(msge)
            print(msge)
        file.write("\n")
        print("\n")

except Error as err:
    print("error connecting database or opening file")
    print(err)
    exit()
finally:

    # finally closing the connection
    con.close()
    file.close()
