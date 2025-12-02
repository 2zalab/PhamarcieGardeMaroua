<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        .header {
            background: linear-gradient(135deg, #0d9488 0%, #059669 100%);
            color: white;
            padding: 30px;
            border-radius: 10px 10px 0 0;
            text-align: center;
        }
        .content {
            background: #f9fafb;
            padding: 30px;
            border: 1px solid #e5e7eb;
        }
        .info-row {
            margin-bottom: 20px;
            padding-bottom: 20px;
            border-bottom: 1px solid #e5e7eb;
        }
        .info-row:last-child {
            border-bottom: none;
        }
        .label {
            font-weight: bold;
            color: #0d9488;
            margin-bottom: 5px;
        }
        .value {
            color: #374151;
        }
        .message-box {
            background: white;
            padding: 20px;
            border-radius: 8px;
            border-left: 4px solid #0d9488;
        }
        .footer {
            background: #1f2937;
            color: #9ca3af;
            padding: 20px;
            text-align: center;
            border-radius: 0 0 10px 10px;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1 style="margin: 0;">📧 Nouveau message de contact</h1>
        <p style="margin: 10px 0 0 0; opacity: 0.9;">Pharmacie de Garde Maroua</p>
    </div>

    <div class="content">
        <div class="info-row">
            <div class="label">👤 Nom</div>
            <div class="value">{{ $data['name'] }}</div>
        </div>

        <div class="info-row">
            <div class="label">📧 Email</div>
            <div class="value">{{ $data['email'] }}</div>
        </div>

        @if(!empty($data['phone']))
        <div class="info-row">
            <div class="label">📱 Téléphone</div>
            <div class="value">{{ $data['phone'] }}</div>
        </div>
        @endif

        <div class="info-row">
            <div class="label">📋 Sujet</div>
            <div class="value">{{ $data['subject'] }}</div>
        </div>

        <div class="info-row">
            <div class="label">💬 Message</div>
            <div class="message-box">
                {{ $data['message'] }}
            </div>
        </div>
    </div>

    <div class="footer">
        <p style="margin: 0;">Ce message a été envoyé depuis le formulaire de contact de Pharmacie de Garde Maroua</p>
        <p style="margin: 10px 0 0 0;">© {{ date('Y') }} Maroua Innovation Technology. Tous droits réservés.</p>
    </div>
</body>
</html>
