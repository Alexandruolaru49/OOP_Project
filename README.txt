Olaru Alexandru 321 CD

Detaliile legate de implementarea si functionalitatea metodelor sunt regasite in javaDoc-urile
ficarei metode in parte.

Design-Patterns utilizate: Singleton, Factory, Strategy

Clasele care nu fac parte din scheletul initial al proiectului se gasesc in pachetele "classes",
"reader", "writer" si "simulation" din pachetul "src".

In pachetul "reader" am construit doua clase, ce ajuta la citirea datelor de intrare din testele
 oferite.
	- Clasa "Input" contine campurile ce se doresc a fi citite ca date de intrare, un constructor
	ce seteaza toate aceste campuri la valorile oferite ca parametri, precum si setteri si getteri.
	
	- Clasa "InputLoader" contine un camp de tip String, semnificand calea de input, un constructor
	ce seteaza aceasta cale si metoda "read". Prin intermediul acestei metode, a fost realizata
	parsarea datelor din fisierele de input si mapparea lor la obiectele create in cadrul metodei.
	Asadar, la final, am creat un obiect de tipul "Input", setandu-i campurile cu valorile citite
	din fisier.
	
	
In pachetul "classes":
	- Clasa "Santa" (din pachetul "SantaClaus")contine 2 campuri, in care vor fi salvate bugetul
	lui Mos Craciun si lista sade cadouri. Aceasta clasa creeaza un obiect Singleton prin metoda
	"getInstance", iar cu ajutorul metodei "getAllScores" calculeaza suma tuturor scorurilor
	medii de cumintenie ale tuturor copiilor din lista.
	
	- Clasa "Gift" (din pachetul "Presents") contine proprietatile pe care le poate avea un cadou:
	numele, pretul si categoria din care face parte. Clasa mai contine si un copy-constructor.
	
	- Pachetul "Changes" contine doua clase: "AnnualChanges", ale carei campuri sunt schimbarile
	anuale si "ChildrenUpdate", care salveaza id-ul pentru copilul cu modificari si noul sau
	scor de cumintenie, impreuna cu noile preferinte de cadouri.
	
	- Pachetul "Children" are in interiorul sau mai multe clase. Clasa "Child" este o superclasa
	pentru toate celelalte din acelasi pachet, continand campurile definitorii ale unui copil. 
	Pe langa un copy-constructor, se regasesc si metodele: "calculateAssignedBudget" si
	"calculateReceivedGifts" care calculeaza si seteaza bugetul asignat copiilor si, respectiv,
	cadourile pe care acestia le primesc. Toate celelalte clase din cadrul pachetului reprezinta
	tipurile de copii, fiecare mostenind campurile si metodele superclasei. Acestea au doar un
	constructor, ce primeste ca parametru un obiect de tip "Child", setand campurile la valorile
	respective.
	
	*Aceste clase de pana acum sunt utilizate,in mare parte, in scopul stocarii informatiilor legate
	de respectivele obiecte, insa unele contin si cateva metode care ajuta la simularea rundelor.
	
	- Pachetul "Factory" contine clasa "ChildrenFactory". Avand un nume foarte sugestiv, clasa are
	rolul de a crea instante de tip "Child" (mai multe tipuri de copii) in functie de tipul acestora
	 (tipul este "calculat" dupa varsta), fiind folosit design-patternul "Factory". 
	
	- Pachetul "Strategies" are mai multe metode si utilizeaza design-patternul "Strategy", care se
	foloseste, de asemenea, si de "Factory". In primul rand, este creata interfata
	"UpdateChildrenStrategy" ce contine semnatura metodei "calculateAverageScore". Pentru fiecare tip
	diferit de copil se va calcula media scorurilor de cumintenie intr-un mod diferit. Din aceasta
	cauza am decis ca acest design-pattern este potrivit pentru implementarea acestei functionalitati.
	Clasa "StrategyFactory" are rolul de a crea tipul strategiei, in functie de varsta copilului.
	Astfel, se pot crea mai multe tipuri de strategii: "BabyUpdateStrategy", "KidUpdateStrategy",
	"TeenUpdateStrategy" si "YoungAdultUpdateStrategy", toate aceste clase implementand interfata
	"UpdateChildrenStrategy". Fiecare implementeaza metoda "calculateAverageScore" intr-o maniera
	unica, in functie de tipul fiecarui copil. Intr-un final, clasa "ApplyStrategy" isi doreste sa
	aplice strategia pe lista de copii primita ca parametru in metoda cu acelasi nume. Pentru fiecare
	copil din lista se defineste tipul in functie de varsta, se creeaza tipul de copil si tipul de 
	strategie (prin metodele din clasele de tip "Factory"), se calculeaza media si se adauga noul
	copil in noua lista actualizata, care va fi returnata de catre metoda.
	
	
In pachetul "simulation":
	- Atat clasa "Initialize" cat si clasa "Updates" utilizeaza design-patternul Singleton.
	Ele sunt clase ce contin doar metode, fiind concepute pentru a realiza simularea "jocului"
	pe parcursul tuturor anilor. Clasa "Initialize" contine metode ce vor crea lista de copii
	pentru anul 0, iar cealalta primeste schimbarile anuale si le aplica, creand listele pentru
	ceilalti ani ai simularii.
	

In pachetul "writer"
	- Prin clasa "Output" va fi creata o instanta care reprezinta obiectul intreg pe care il vom
	afisa in fisierele de output. Acesta contine o lista ce semnifica o lista cu listele cu copii
	din toti anii. Clasa "Auxiliary" contine, la randul ei, un camp ce este o lista cu copii.
	Contine o metoda care seteaza lista de copii anuala, care va fi adaugata la obiectul "mare".
	Asadar, la final, instanta clasei "Output" va avea in campul "annualChildren", listele din toti
	anii cu copiii ce trebuie afisati.
	- Clasa "WriteOutput" contine o metoda ce primeste ca parametru obiectul final de tip "Output" si
	calea de output si va scrie valoarea obiectului in fisierul corespunzator repsectivei cai.
	

In pachetul "main"
	- Se regaseste clasa "Main". Aceasta contine metoda cu acelasi nume care creeaza fisierele de
	output omoloage fisierelor de input si apeleaza metoda "action" pentru fiecare test,trimitandu-i
	ca parametri calea de input si de output. In aceasta, se face citirea datelor, se creeaza
	corespunzator listele anuale de copii, care mai apoi se adauga la obiectul de tip "Output".
	La final se apeleaza metoda de scriere in fisier.
	
	
	
Mai concis, modul in care am gandit implementarea este urmatorul: pentru lista de copii curenta
am folosit design-patternul "Factory" pentru a crea o instanta noua de tipul unei subclase a clasei
"Child", iar aceasta instanta a fost trimisa ca parametru strategiei, create si ea cu un "factory"
in functie de tipul copilului, care calcula astfel scorul mediu de cumintenie si ii era asignat
noului obiect. Aceste instante erau adaugate intr-o noua lista, care era transmisa ca parametru
pentru noul an. De asemenea, pe langa aceste 2 design-patternuri, am mai utilizat si "Singleton"
in cadrul anumitor clase. 	