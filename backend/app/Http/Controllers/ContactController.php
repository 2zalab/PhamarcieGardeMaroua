<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Mail;
use App\Mail\ContactMail;

class ContactController extends Controller
{
    public function show()
    {
        return view('contact');
    }

    public function send(Request $request)
    {
        $validated = $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|email|max:255',
            'phone' => 'nullable|string|max:20',
            'subject' => 'required|string|max:255',
            'message' => 'required|string|max:5000',
        ]);

        try {
            // Envoyer l'email
            Mail::to('contact@mit.cm')->send(new ContactMail($validated));

            return redirect()->route('contact')
                ->with('success', 'Votre message a été envoyé avec succès ! Nous vous répondrons dans les plus brefs délais.');
        } catch (\Exception $e) {
            return redirect()->route('contact')
                ->with('error', 'Une erreur est survenue lors de l\'envoi du message. Veuillez réessayer plus tard.')
                ->withInput();
        }
    }
}
