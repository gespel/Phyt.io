from Bio.Seq import Seq
my_seq = Seq("AGTACACTGGTTGACCTATGGCAGTAA")
print(my_seq.find("G"))
print(my_seq.transcribe())
print(my_seq.transcribe().translate())