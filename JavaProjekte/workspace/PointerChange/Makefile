CXXFLAGS =	-O2 -g -Wall -fmessage-length=0

OBJS =		PointerChange.o

LIBS =

TARGET =	PointerChange.exe

$(TARGET):	$(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

all:	$(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
