<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('payments', function (Blueprint $table) {
            $table->id();
            $table->foreignId('user_id')->constrained()->onDelete('cascade');
            $table->string('external_reference')->unique();
            $table->string('campay_reference')->nullable();
            $table->integer('amount'); // Montant en FCFA
            $table->string('currency')->default('XAF');
            $table->string('description');
            $table->enum('status', ['PENDING', 'SUCCESSFUL', 'FAILED'])->default('PENDING');
            $table->string('payment_provider')->default('campay');
            $table->string('payment_method')->nullable(); // MTN, ORANGE, etc.
            $table->string('phone_number')->nullable();
            $table->string('ussd_code')->nullable();
            $table->text('campay_response')->nullable(); // JSON response from CamPay
            $table->text('error_message')->nullable();
            $table->timestamp('paid_at')->nullable();
            $table->timestamps();

            $table->index(['user_id', 'status']);
            $table->index('external_reference');
            $table->index('campay_reference');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('payments');
    }
};
