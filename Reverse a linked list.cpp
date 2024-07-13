class Solution
{
    public:
    //Function to reverse a linked list.
    struct Node* reverseList(struct Node *head)
    {
        // code here
        // return head of reversed list
        struct Node *prev = NULL;
        struct Node *curr = head;
        struct Node *nextptr;
        
        while(curr!=NULL)
        {
            nextptr = curr->next;
            curr->next = prev;
            
            prev = curr;
            curr = nextptr;
        }
        return prev;
    }
    
};
