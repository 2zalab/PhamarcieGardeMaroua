<?php

namespace App\Http\Controllers\Web;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class AuthController extends Controller
{
    /**
     * Afficher le formulaire de connexion
     */
    public function showLoginForm()
    {
        // Si déjà connecté, rediriger vers le dashboard
        if (session()->has('admin_id')) {
            return redirect()->route('admin.dashboard');
        }

        return view('admin.login');
    }

    /**
     * Traiter la connexion
     */
    public function login(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'email' => 'required|email',
            'password' => 'required|string',
        ]);

        if ($validator->fails()) {
            return redirect()->back()
                ->withErrors($validator)
                ->withInput();
        }

        // Trouver l'utilisateur
        $user = User::where('email', $request->email)->first();

        // Vérifier le mot de passe et les droits admin
        if (!$user || !Hash::check($request->password, $user->password)) {
            return redirect()->back()
                ->with('error', 'Email ou mot de passe incorrect.')
                ->withInput();
        }

        if (!$user->isAdmin()) {
            return redirect()->back()
                ->with('error', 'Vous n\'avez pas les droits d\'administrateur.')
                ->withInput();
        }

        // Créer la session
        session(['admin_id' => $user->id]);
        session(['admin_name' => $user->name]);
        session(['admin_email' => $user->email]);

        return redirect()->route('admin.dashboard')
            ->with('success', 'Connexion réussie! Bienvenue ' . $user->name);
    }

    /**
     * Déconnexion
     */
    public function logout()
    {
        session()->forget(['admin_id', 'admin_name', 'admin_email']);
        session()->flush();

        return redirect()->route('admin.login')
            ->with('success', 'Vous avez été déconnecté avec succès.');
    }
}
