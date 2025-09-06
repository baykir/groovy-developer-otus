import com.google.common.base.Joiner

def list = ['Hello', 'OTUS', 'from', 'Guava']
def result = Joiner.on(' ').join(list)
println result
