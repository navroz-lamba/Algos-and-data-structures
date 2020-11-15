

class Node():
    
    def __init__(self, value): 
        self.value = value
        self.next = None


class ErgLinkedList():

    def __init__(self):
        self.first = None
        self.last = None
        self.size = 0

    def isEmpty(self):
        return self.size == 0

    def displayContents(self):
        current = self.first
        
        while(current):
            print(current.value)
            current = current.next
        # print("finished")


    def erg_addFirst(self, value):

        new_node = Node(value)

        if self.isEmpty():
            self.first = self.last = new_node

        else:
            new_node.next = self.first
            self.first = new_node
        
        self.size += 1

    def erg_addLast(self, value):
        # find the last node
        # make the next node of that this node
        # make this node equal to last node
        # increment the size

        new_node = Node(value)

        if self.isEmpty():
            self.first = self.last = new_node
        else:
            self.last.next = new_node
            self.last = new_node

        self.size += 1

    def erg_deleteFirst(self):

        if self.isEmpty():
            return
        second_node = self.first.next
        self.first.next = None
        self.first = second_node
        self.size -= 1

    def erg_deleteLast(self):
        # not a great implementation.  
        # need to account for edge cases
        # only one node; empty list

        
        if self.isEmpty():
            return

        current = self.first
        previous_node = self.first

        while current.next: # when there is a next
            previous_node = current
            current = current.next
        previous_node.next = None
        
        self.last = previous_node
        self.last.next = None

        self.size -= 1


    def erg_contains(self, item): 

        if self.isEmpty():
            return
        current = self.first
        while current:
            if current.value == item:
                return True
            current = current.next
        return False

    def erg_indexOf(self, item):

        if self.isEmpty():
            return
        index_count = 0
        current = self.first
        while(current):
            if current.value == item:
                return index_count
            current = current.next
            index_count += 1
        return -1

    def erg_reverse(self):

        if self.isEmpty():
            return
        current_node = self.first
        prev_node = None
        next_node = None

        #i might have to set the last node before
        # I enter the looop

        while(current_node):
            prev_node= current_node.next
            if prev_node == None:
                self.last = self.first
                self.first = current_node
            current_node.next = next_node
            next_node = current_node
            current_node = prev_node

    def get_Kth_from_end(self, k):
        # distance = k-1
        # move the second pointer distance times.
        # then move both pointers until second is at the end
        # return the value of first
        if self.isEmpty():
            return

        first_point = self.first
        second_point = self.first
        distance = k -1 

        if self.size < k:
            print("Invalid Input. K must be smaller than list.")
            return 
        # create distance between first and second

        for i in range(0, distance):
            second_point = second_point.next

        while(second_point.next != None):
            second_point = second_point.next
            first_point = first_point.next

        return first_point.value

    def get_middle(self):
        # for every two steps the second moves
        # move the first by one step

        if self.isEmpty():
            return
        first_point = self.first
        second_point = self.first
        step_count = 0 

        while(second_point.next != None):
            
            second_point = second_point.next
            step_count += 1
            if step_count%2 == 0:
                first_point = first_point.next
            
        
        if step_count%2 != 0:
            
            return (first_point.value, first_point.next.value)
        else:
            return first_point.value
    
    def hasLoop(self):
        # basically just make one go faster than the other
        # can check equality until you get to the end or 
        # find the loop
        slow = self.first
        fast = self.first

        while(fast.next != None) and fast.next.next != None:
            fast = fast.next.next
            slow = slow.next

            if fast == slow:
                return True

        return False





# addFirst, addLast, 
# deleteFirst, deleteLast,
#  contains, indexOf
# get Kth from the end
# middle of list in one pass

test_linkedList = ErgLinkedList()
test_linkedList.erg_addFirst(28)
test_linkedList.erg_addFirst(15)
test_linkedList.erg_addFirst(11)
test_linkedList.erg_addLast(72)

test_linkedList.displayContents()
print("Deleting first")
# test_linkedList.erg_deleteFirst()
test_linkedList.erg_addFirst(13)
# test_linkedList.displayContents()
# print("Deleting last")
# test_linkedList.erg_deleteLast()
test_linkedList.displayContents()
print(f"first: {test_linkedList.first.value}")
print(f"last: {test_linkedList.last.value}")
print("Reverse List")
test_linkedList.erg_reverse()
test_linkedList.displayContents()
# print("Check contains 28")
# print(test_linkedList.erg_contains(28))
# print("Index of 28")
# print(test_linkedList.erg_indexOf(15))
# print(f"first: {test_linkedList.first.value}")
# print(f"last: {test_linkedList.last.value}")
print()
print(test_linkedList.get_Kth_from_end(7))
print()
print(f"Middle node value is : {test_linkedList.get_middle()}")