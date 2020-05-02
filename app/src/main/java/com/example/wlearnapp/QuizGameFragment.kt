package com.example.wlearnapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.wlearnapp.databinding.FragmentQuizGameBinding
import kotlinx.android.synthetic.main.fragment_quiz_game.*

/**
 * A simple [Fragment] subclass.
 */
class QuizGameFragment : Fragment() {
    lateinit var binding: FragmentQuizGameBinding
    lateinit var currentQuestion: Question
    private var questionIndex = 0
    val maxNumberOfQuestion = 5
    lateinit var answers:ArrayList<String>
    lateinit var selectedAnswer:String
    var wrongAnswerList:ArrayList<String> = ArrayList()
    var score = 0

    // OSI TCP/IP Model
    var questions = arrayListOf<Question>(
        Question("What layer in the TCP/IP stack is equivalent to the Transport layer of the OSI model?",
            arrayListOf("Host-to-Host", "Application", "Network", "Network Access")),
        Question("The DoD model (also called the TCP/IP stack) has four layers. Which layer of the DoD model is equivalent to the Network layer of the OSI model?",
            arrayListOf("Internet layer", "Application layer", "Transport layer", "Network Interface")),
        Question("Which protocols are found in the network layer of the OSI reference model and are responsible for path determination and traffic switching?",
            arrayListOf("Routing", "LAN", "WAN", "Network")),
        Question("Which layer in the OSI reference model is responsible for determining the availability of the receiving program and checking to see if enough resources exist for that communication?",
            arrayListOf("Application", "Presentation", "Session", "Transport")),
        Question("Which layer of the OSI reference model uses the hardware address of a device to ensure message delivery to the proper host on a LAN?",
            arrayListOf("Data Link", "Application", "Network", "Physical"))
    )

    /*
    // ARQs
    var questions = arrayListOf<Question>(
<<<<<<< HEAD
        Question("In the _________ Protocol, the sender sends one frame, stops until it receives confirmation from the receiver, and then sends the next frame.",
            arrayListOf("Stop-and-Wait", "Simplest", "Go-Back-N ARQ", "Selective-Repeat ARQ")),
        Question("In the _________ Protocol, if no acknowledgment for a frame has arrived, we resend all outstanding frames.",
            arrayListOf("Go-Back-N ARQ", "Stop-and-Wait", "Simplest", "Selective-Repeat ARQ")),
        Question("In the _________ Protocol we avoid unnecessary transmission by sending only frames that are corrupted.",
=======
        Question("In the _____ Protocol, the sender sends one frame, stops until it receives confirmation from the receiver, and then sends the next frame.",
            arrayListOf("Stop-and-Wait", "Simplest", "Go-Back-N ARQ", "Selective-Repeat ARQ")),
        Question("In the _________Protocol, if no acknowledgment for a frame has arrived, we resend all outstanding frames.",
            arrayListOf("Go-Back-N ARQ", "Stop-and-Wait", "Simplest", "Selective-Repeat ARQ")),
        Question("In the _________ protocol we avoid unnecessary transmission by sending only frames that are corrupted.",
>>>>>>> e4e42cbb1c18717836c2c983652c68355f2cd9aa
            arrayListOf("Selective-Repeat ARQ", "Go-Back-N ARQ", "Stop-and-Wait", "Simplest")),
        Question("Both Go-Back-N and Selective-Repeat Protocols use a _________.",
            arrayListOf("Sliding window", "Sliding frame", "Sliding packet", "Sliding protocol")),
        Question("In Selective Repeat ARQ, if 5 is the number of bits for the sequence number, then the maximum size of the send window must be ",
            arrayListOf("16", "15", "31", "1"))
    )
<<<<<<< HEAD
        // Routing protocol
    var questions = arrayListOf<Question>(
        Question("A network administrator uses the RIP routing protocol to implement routing within an autonomous system. What are characteristics of this protocol?",
            arrayListOf("It periodically sends complete routing tables to all connected devices.", "It displays an actual map of the network topology.", "It offers rapid convergence in large networks.", "It is beneficial in complex and hierarchically designed networks.")),
        Question("What is the first step OSPF and IS-IS routers take in building a shortest path first database?",
            arrayListOf("Learn about directly connected networks", "Send hello to discover neighbors and form adjacencies", "Choose successors and feasible successors to populate the topology table", "Flood LSPs to all neighbors informing them of all known networks and their link states")),
        Question("Which one statements is true regarding link-state routing protocols?",
            arrayListOf("They are aware of the complete network topology.", "They do not include subnet masks in their routing updates.", "They rely on decreasing hop counts to determine the best path.", "They pass their entire routing tables to their directly connected neighbors only.")),
        Question("A network administrator needs to configure a single router to load-balance the traffic over unequal cost paths. Which routing protocol should the administrator use?",
            arrayListOf("EIGRP", "OSPF", "RIPv1", "RIPv2")),
        Question("What should be considered when troubleshooting a problem with the establishment of neighbor relationships between OSPF routers?",
            arrayListOf("Interface network type mismatch", "Administrative distance mismatch", "No loopback interface configured", "Gateway of last resort not redistributed"))
    )

    // TCP congestion control
    var questions = arrayListOf<Question>(
        Question("The growth of congestion window takes place _________.",
            arrayListOf("Up to the size of receiver’s window", "Infinitely", "Up to Threshold", "Up to timeout")),
        Question("In the congestion avoidance algorithm, the size of the congestion window increases ____________ until congestion is detected.",
            arrayListOf("additively", "exponentially", "multiplicatively", "suddenly")),
        Question("In the slow-start algorithm, the size of the congestion window increases __________ until it reaches a threshold.",
            arrayListOf("exponentially", "additively", "multiplicatively", "suddenly")),
        Question("Retransmission of packets must not be done when _________.",
            arrayListOf("Packet is error-free", "Packet is lost", "Packet is corrupted", "Packet is needed")),
        Question("The technique of ________ refers to a congestion control mechanism in which a congested node stops receiving data from the immediate upstream node or nodes.",
            arrayListOf("backpressure", "chock packet", "implicit signaling", "explicit signaling"))
    )
=======
>>>>>>> e4e42cbb1c18717836c2c983652c68355f2cd9aa
    */

    private fun randomQuestion() {
        questions.shuffle()
        setQuestion()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz_game,container,false)
        randomQuestion()
        binding.quiz = this
        return binding.root
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = ArrayList(currentQuestion.theAnswer)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0]+" "+answers[1]+" "+answers[2]+" "+answers[3])
        Log.d("ANSWERREAL", currentQuestion.theAnswer[0])
    }

    private fun checkAnswer(answer:String) {
        if(answer.equals(currentQuestion.theAnswer[0])) {
            score+=1
        }
        else {
            wrongAnswerList.add(currentQuestion.theQuestion)
        }
        questionIndex++
        if(questionIndex<maxNumberOfQuestion) {
            setQuestion()
            binding.invalidateAll()
        }
        else {
            getScore()
        }
    }
/*
    private fun getScore() {
        if (score>=5) {
            Toast.makeText(activity,"Won", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(activity,"Lost", Toast.LENGTH_SHORT).show()
        }
    }
*/


    private fun getScore() {
        if(score>=5) {
            Navigation.findNavController(view!!).navigate(R.id.action_quizGameFragment_to_quizWonFragment)
        }
        else {
            //Navigation.findNavController(view!!).navigate(R.id.action_quizGameFragment_to_quizFragment)
            //Navigation.findNavController(view!!).navigate(R.id.action_quizGameFragment_to_quizLostFragment)
            Navigation.findNavController(view!!).navigate(R.id.action_quizGameFragment_to_quizLostFragment)
            //Navigation.findNavController(view!!).navigate(R.id.action_quizGameFragment_to_quizWonFragment)
        }
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        option1.setOnClickListener {
            checkAnswer(option1.text.toString())
        }
        option2.setOnClickListener {
            checkAnswer(option2.text.toString())
        }
        option3.setOnClickListener {
            checkAnswer(option3.text.toString())
        }
        option4.setOnClickListener {
            checkAnswer(option4.text.toString())
        }
    }
}