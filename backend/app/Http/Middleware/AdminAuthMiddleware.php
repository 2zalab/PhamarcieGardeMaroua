<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;

class AdminAuthMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Closure(\Illuminate\Http\Request): (\Symfony\Component\HttpFoundation\Response)  $next
     */
    public function handle(Request $request, Closure $next): Response
    {
        // Vérifier si l'utilisateur est connecté via session
        if (!session()->has('admin_id')) {
            return redirect()->route('admin.login')->with('error', 'Veuillez vous connecter pour accéder à cette page.');
        }

        // Vérifier si l'utilisateur est bien admin
        $userId = session('admin_id');
        $user = \App\Models\User::find($userId);

        if (!$user || !$user->isAdmin()) {
            session()->forget('admin_id');
            return redirect()->route('admin.login')->with('error', 'Accès non autorisé.');
        }

        return $next($request);
    }
}
