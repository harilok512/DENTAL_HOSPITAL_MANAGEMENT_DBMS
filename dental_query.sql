use dental_mngmnt_sys;
insert into Doctor values('DD111','Natasha',8745632,'Orthodontics');
insert into patient values('DP010','Clair',4782964,33,'los angeles');

update patient set age=38 where patient_id='DP010';
update Doctor set doctor_number=6783434 where doctor_Id='DD111';

delete from Doctor where doctor_id='DD111';

select * from Treatment;

select  a.patient_patient_id, p.patient_name
from patient p
inner join  Appointment a on a.patient_patient_id = p.patient_id;

select  a.Doctor_Doctor_Id, d.Doctor_name
from Doctor d
inner join  Appointment a on a.Doctor_Doctor_Id= d.Doctor_Id;

Select count(patient_id),address
from patient
group by address
order by count(patient_id);

select count(appointment_id), appointment_date
from Appointment
group by appointment_date;

select patient_id from patient
union
select patient_patient_id from Appointment;

select p.patient_name, a.appointment_date
from patient p, Appointment a
where p.patient_id=a.patient_patient_id;

select * from Transactions;